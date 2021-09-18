package com.fonteraro.martaco.cinemahub.utils

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T): ResultWrapper<T>()
    data class NetworkError(val message: String?): ResultWrapper<Nothing>()
    data class GenericError(val message: String?): ResultWrapper<Nothing>()
}
