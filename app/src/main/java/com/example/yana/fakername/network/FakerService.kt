package com.example.yana.fakername.network

import com.example.yana.fakername.dataClass.Countries
import com.example.yana.fakername.dataClass.ListCountries
import retrofit2.http.GET
import retrofit2.http.Path

interface FakerService {

    @GET("countries")
    suspend fun loadCountries(
    ): List<Countries>?
}