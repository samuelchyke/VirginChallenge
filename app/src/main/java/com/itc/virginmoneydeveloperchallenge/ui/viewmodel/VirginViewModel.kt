package com.itc.virginmoneydeveloperchallenge.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.itc.virginmoneydeveloperchallenge.repository.VirginRepository
import com.itc.virginmoneydeveloperchallenge.util.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class VirginViewModel @Inject constructor(
    private val virginRepository: VirginRepository
) : ViewModel() {

    private val _rooms: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val rooms: LiveData<UIState> get() = _rooms

    private val _people: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val people: LiveData<UIState> get() = _people

    fun getRooms() {
        CoroutineScope(Dispatchers.IO).launch {

            try {
                val response = virginRepository.getRooms()
                if (response.isSuccessful) {
                    response.body()?.let {

                        _rooms.postValue(UIState.SUCCESS(it))

                    } ?: throw Exception("Data Null")
                } else {
                    throw Exception(response.errorBody()?.string())
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _rooms.postValue(UIState.ERROR(e))
                }
            }
        }
    }

    fun getPeople() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = virginRepository.getPeople()
                if (response.isSuccessful) {
                    response.body()?.let {

                        _people.postValue(UIState.SUCCESS(it))

                    } ?: throw Exception("Data Null")
                } else {
                    throw Exception(response.errorBody()?.string())
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _people.postValue(UIState.ERROR(e))
                }
            }
        }
    }

    public override fun onCleared() {
        super.onCleared()
    }

}