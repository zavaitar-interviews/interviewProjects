package com.zavaitar.core.network.util

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: String? = null) : Result<Nothing>()
}
