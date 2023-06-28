package com.example.data.di

import com.example.data.remote.FakerApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Singleton
    @Provides
    @Named("logging")
    internal fun provideHttpLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor { message ->
            Timber.d(message)
        }.setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    fun provideOkHttp(
        @Named("logging") httpLoggingInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10L, TimeUnit.SECONDS)
            .writeTimeout(10L, TimeUnit.SECONDS)
            .readTimeout(30L, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun provideRetroFit(
        okHttpClient: OkHttpClient, moshi: Moshi,
        @Named("SPOONACULAR_BASE_URL") baseUrl: String,
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    @Singleton
    @Provides
    fun provideFakerApi(retrofit: Retrofit): FakerApi =
        retrofit.create(FakerApi::class.java)
}