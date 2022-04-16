package com.example.yana.fakername.network

import android.content.Context
import com.example.yana.fakername.prefs.SharedPreferenceFaker
import okhttp3.Interceptor
import okhttp3.Response

class FakerInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("X-API-KEY", SharedPreferenceFaker.toString())
            .build()

        return chain.proceed(request)
    }
}