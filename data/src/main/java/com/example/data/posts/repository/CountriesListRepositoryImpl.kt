package com.example.data.posts.repository

import com.example.data.remote.FakerApi
import com.example.model.Countries
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CountriesListRepositoryImpl @Inject constructor(
    private val api: FakerApi
) : CountriesListRepository {
    override suspend fun getCountriesList(): List<Countries>? {
        return  api.getCountries()
    }
}