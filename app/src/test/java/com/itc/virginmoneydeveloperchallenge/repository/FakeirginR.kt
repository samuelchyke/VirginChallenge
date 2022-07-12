package com.itc.virginmoneydeveloperchallenge.repository

import com.itc.virginmoneydeveloperchallenge.api.VirginServiceApi
import com.itc.virginmoneydeveloperchallenge.model.people.PeopleResponse
import com.itc.virginmoneydeveloperchallenge.model.rooms.RoomsResponse
import com.itc.virginmoneydeveloperchallenge.model.rooms.RoomsResponseItem
import com.itc.virginmoneydeveloperchallenge.repository.VirginRepository
import com.itc.virginmoneydeveloperchallenge.repository.VirginRepositoryImpl
import retrofit2.Response
import javax.inject.Inject

//class FakeVirginRepository() : VirginRepository {

    private val roomResponse = mutableListOf<RoomsResponse>()

//    private val roomResponseItem : RoomsResponseItem()


//    override suspend fun getRooms(): MutableList<RoomsResponse> {
//
//    }
//
//    override suspend fun getPeople(): MutableList<PeopleResponse> {
//        TODO("Not yet implemented")
//    }
//}
//
//interface VirginRepository {
//    suspend fun getRooms(): MutableList<RoomsResponse>
//    suspend fun getPeople(): MutableList<PeopleResponse>
//}

