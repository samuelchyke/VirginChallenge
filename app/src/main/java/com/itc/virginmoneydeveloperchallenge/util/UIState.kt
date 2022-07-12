package com.itc.virginmoneydeveloperchallenge.util

import com.itc.virginmoneydeveloperchallenge.model.people.PeopleResponse
import com.itc.virginmoneydeveloperchallenge.model.rooms.RoomsResponse

sealed class UIState{

    object LOADING: UIState()
    data class SUCCESS(val response: Any): UIState()
    data class ERROR (val error: Exception): UIState()

}

