package com.example.data.remote

import com.example.model.Countries
import com.example.model.DocumentsUser
import com.example.model.Search
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FakerApi {
    @GET("search")
    suspend fun searchDocuments(
        @Query("text") text: String,
        @Query("page") page: Int?,
        @Query("country_id") country_id: Int?
    ): Search?

    @GET("countries")
    suspend fun getCountries(
    ): List<Countries>?
}