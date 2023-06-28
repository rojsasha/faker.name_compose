package com.example.domain.usecases.counties

import android.util.Log
import com.example.base.inject.IoDispatcher
import com.example.base.result.Results
import com.example.data.posts.repository.CountriesListRepository
import com.example.domain.SuspendUseCase
import com.example.domain.UseCase
import com.example.model.Countries
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CountriesListUseCase @Inject constructor(
    private val countriesRepository: CountriesListRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : SuspendUseCase<Unit, List<Countries>>(ioDispatcher) {

    override suspend fun execute(parameters: Unit): List<Countries> {
        try {
            val s = countriesRepository.getCountriesList()
            Log.d("CountriesListUseCase", "execute: $s")
            s
        }catch (e: Exception) {
            Log.d("CountriesListUseCase", "execute: ${e.message}")
        }
        return countriesRepository.getCountriesList() ?: emptyList()
//        return try {
//            val countries = countriesRepository.getCountriesList()
//            Results.Success(countries)
//        } catch (e: Exception) {
//           Results.Error(e)
//        }
    }
}