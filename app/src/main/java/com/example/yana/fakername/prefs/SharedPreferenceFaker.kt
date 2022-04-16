package com.example.yana.fakername.prefs

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceFaker {

    private const val KEY = "text"
    private var preference: SharedPreferences? = null

    fun saveKey(context: Context) {
        preference = context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
    }
}