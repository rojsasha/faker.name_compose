package com.example.data.posts.repository

import com.example.model.Countries
import kotlinx.coroutines.flow.Flow

interface CountriesListRepository {
    suspend fun getCountriesList(): List<Countries>?
}