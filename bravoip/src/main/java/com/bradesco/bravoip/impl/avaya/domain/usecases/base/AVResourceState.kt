package com.bradesco.bravoip.impl.avaya.domain.usecases.base

sealed class AVResourceState<out T> {
    data class Success<T>(val data: T) : AVResourceState<T>()
    data class Error(val message: String) : AVResourceState<Nothing>()
    object Loading : AVResourceState<Nothing>()
}

inline fun <reified T> AVResourceState<T>.doIfError(callback: (error: String) -> Unit) {
    if (this is AVResourceState.Error) {
        callback(message)
    }
}

inline fun <reified T> AVResourceState<T>.doIfSuccess(callback: (value: T) -> Unit) {
    if (this is AVResourceState.Success) {
        callback(data)
    }
}

inline fun <reified T> AVResourceState<T>.doIfLoading(callback: () -> Unit) {
    if (this is AVResourceState.Loading) {
        callback()
    }
}

inline fun <reified T, reified R> AVResourceState<T>.map(transform: (T) -> R): AVResourceState<R> {
    return when (this) {
        is AVResourceState.Success -> AVResourceState.Success(transform(data))
        is AVResourceState.Error -> this
        else -> AVResourceState.Loading
    }
}