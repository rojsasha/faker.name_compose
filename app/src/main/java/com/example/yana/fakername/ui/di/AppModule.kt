package com.example.yana.fakername.ui.di

import com.example.yana.fakername.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

const val SPOONACULAR_BASE_URL = "SPOONACULAR_BASE_URL"

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Named(SPOONACULAR_BASE_URL)
    fun provideSpoonCularBaseUrlKey(): String = BuildConfig.SPOONACULAR_BASE_URL
}