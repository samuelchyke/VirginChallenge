package com.itc.virginmoneydeveloperchallenge.api

import com.itc.virginmoneydeveloperchallenge.model.people.PeopleResponse
import com.itc.virginmoneydeveloperchallenge.model.rooms.RoomsResponse
import retrofit2.Response
import retrofit2.http.GET

interface VirginServiceApi {

    @GET(ROOMS_PATH)
    suspend fun getRooms():Response<RoomsResponse>

    @GET(PEOPLE_PATH)
    suspend fun getPeople():Response<PeopleResponse>

    companion object{

        const val BASE_URL = "https://61e947967bc0550017bc61bf.mockapi.io/api/v1/"
        private const val ROOMS_PATH = "rooms"
        private const val PEOPLE_PATH = "people"

    }

}
