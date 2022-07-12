package com.itc.virginmoneydeveloperchallenge.ui.viewmodel

import android.graphics.ColorSpace
import android.view.Display
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.google.common.truth.Truth.assertThat
import com.itc.virginmoneydeveloperchallenge.MainCoroutineRule
import com.itc.virginmoneydeveloperchallenge.model.rooms.RoomsResponse
import com.itc.virginmoneydeveloperchallenge.model.rooms.RoomsResponseItem
import com.itc.virginmoneydeveloperchallenge.repository.VirginRepository
import com.itc.virginmoneydeveloperchallenge.util.UIState
import io.mockk.clearAllMocks
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response
import kotlin.math.E

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
    lateinit var virginViewModel: VirginViewModel
    lateinit var dummyResponse : Response<RoomsResponse>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testIoDispatcher)
        virginViewModel = VirginViewModel(mockRepo)
//        dummyResponse.body()?.add(model())
    }

    @After
    fun tearDown() {
        clearAllMocks()
        Dispatchers.resetMain()
    }

    @Test
    fun `room is set to LOADING before data is retrieved`() = runTest {

            // Assign
            val expectedOutcome = UIState.LOADING

//            `when`(mockRepo.getRooms()).thenReturn(dummyResponse)
            mockRepo.getRooms()

            // Action
            virginViewModel.rooms.observeForever {
                assertThat(it).isNotNull()
                assertThat(it).isEqualTo(expectedOutcome)
            }

//            `when`(mockRepo.getRooms()).thenReturn(dummyResponse)

//         Action when
//            virginViewModel.getRooms()

        }



//
//        //
//        assertEquals("", model())

//
    @Test
    fun `room when room is retrieved not null should return a response `() = runTest {


//        val value = virginViewModel.rooms.value?.let { UIState.SUCCESS(it) }
        val expectedOutcome = UIState.SUCCESS(this)

//            .apply { UIState.SUCCESS(room)  }

        mockRepo.getRooms()

            // Assign
            virginViewModel.rooms.observeForever {
                assertThat(it).isNotNull()
                assertThat(it).isEqualTo(expectedOutcome)
            }

//            `when`(mockRepo.getRooms()).thenReturn(dummyResponse)

//         Action when
//            virginViewModel.getRooms()

        }
    }

//
//        fun mode(): Response<RoomsResponse>{
//            return mode()
//        }

        private fun model(): RoomsResponseItem =
            RoomsResponseItem(
                "12:00:00",
                "1",
                true,
                2
            )






