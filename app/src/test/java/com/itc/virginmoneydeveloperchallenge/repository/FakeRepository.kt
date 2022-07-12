package com.itc.virginmoneydeveloperchallenge.repository

import com.itc.virginmoneydeveloperchallenge.api.VirginServiceApi
import com.itc.virginmoneydeveloperchallenge.model.people.PeopleResponse
import com.itc.virginmoneydeveloperchallenge.model.rooms.RoomsResponse
import com.itc.virginmoneydeveloperchallenge.model.rooms.RoomsResponseItem
import retrofit2.Response
import java.util.Optional.empty
import javax.inject.Inject

class FakeVirginRepository : VirginRepository {

//   private val roomsResponse: Response<RoomsResponse>

    private fun model(): RoomsResponseItem =
        RoomsResponseItem(
            "12:00:00",
            "1",
            true,
            2
        )

    override suspend fun getRooms(): Response<RoomsResponse> {
//        return roomsResponse
            TODO("Not yet implemented")
    }

    override suspend fun getPeople(): Response<PeopleResponse> {
        TODO("Not yet implemented")
    }


}


