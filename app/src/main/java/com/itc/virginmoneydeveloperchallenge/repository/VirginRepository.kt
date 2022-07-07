package com.itc.virginmoneydeveloperchallenge.repository

import com.itc.virginmoneydeveloperchallenge.api.VirginServiceApi
import com.itc.virginmoneydeveloperchallenge.model.people.PeopleResponse
import com.itc.virginmoneydeveloperchallenge.model.rooms.RoomsResponse
import retrofit2.Response
import javax.inject.Inject

interface VirginRepository {
   suspend fun getRooms(): Response<RoomsResponse>
   suspend fun getPeople(): Response<PeopleResponse>
}

class VirginRepositoryImpl @Inject constructor (
   private val virginServiceApi: VirginServiceApi
        ) : VirginRepository{

   override suspend fun getRooms(): Response<RoomsResponse> {
      return virginServiceApi.getRooms()
   }

   override suspend fun getPeople(): Response<PeopleResponse> {
      return virginServiceApi.getPeople()
   }

}
