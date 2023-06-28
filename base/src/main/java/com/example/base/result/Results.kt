package com.example.base.result

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Results<out R> {
    data class Success<out T>(val data: T) : Results<T>()
    data class Error(val exception: Exception) : Results<Nothing>()
    object Loading : Results<Nothing>()
}

val <T> Results<T>.data: T?
    get() = (this as? Results.Success)?.data
