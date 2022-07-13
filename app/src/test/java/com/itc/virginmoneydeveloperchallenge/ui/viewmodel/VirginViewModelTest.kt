package com.itc.virginmoneydeveloperchallenge.ui.viewmodel


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.itc.virginmoneydeveloperchallenge.MainCoroutineRule
import com.itc.virginmoneydeveloperchallenge.model.rooms.RoomsResponse
import com.itc.virginmoneydeveloperchallenge.model.rooms.RoomsResponseItem
import com.itc.virginmoneydeveloperchallenge.repository.VirginRepository
import com.itc.virginmoneydeveloperchallenge.util.UIState
import io.mockk.clearAllMocks
import org.junit.Assert.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class VirginViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val testIoDispatcher = UnconfinedTestDispatcher()
    private val testScope = TestScope(testIoDispatcher)

    @Mock
    lateinit var mockRepo: VirginRepository
    private lateinit var virginViewModel: VirginViewModel
    lateinit var dummyResponse: Response<RoomsResponse>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testIoDispatcher)
        virginViewModel = VirginViewModel(mockRepo)

    }

    @After
    fun tearDown() {
        clearAllMocks()
        Dispatchers.resetMain()
    }

    @Test
    fun `room default val is set to LOADING before data is retrieved return true`() = runTest {

        val expectedOutcome = UIState.LOADING

        mockRepo.getRooms()

        virginViewModel.rooms.observeForever {
            assertThat(it).isNotNull()
            assertThat(it).isEqualTo(expectedOutcome)
        }

    }


}

