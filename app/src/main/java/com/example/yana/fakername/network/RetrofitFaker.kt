package com.example.yana.fakername.network

import com.itkacher.okhttpprofiler.OkHttpProfilerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitFaker {

    fun buildRetrofit(): FakerService {
        return Retrofit.Builder()
            .baseUrl("https://faker.name/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .build()
            .create(FakerService::class.java)
    }
    private fun getClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(FakerInterceptor())
            .addInterceptor(OkHttpProfilerInterceptor())
            .build()
    }
}