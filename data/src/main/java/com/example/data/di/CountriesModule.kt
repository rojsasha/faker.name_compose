package com.example.data.di

import com.example.data.posts.remote.SearchDataSource
import com.example.data.posts.remote.SearchDataSourceImpl
import com.example.data.posts.repository.CountriesListRepository
import com.example.data.posts.repository.CountriesListRepositoryImpl
import com.example.data.remote.FakerApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class CountriesModule {
    @Provides
    fun provideCountriesModule(api: FakerApi): CountriesListRepository =
        CountriesListRepositoryImpl(api)
}