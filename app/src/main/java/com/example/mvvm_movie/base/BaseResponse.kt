package com.example.mvvm_movie.base

data class BaseResponse<T>(val status: Status, val response: T?, val error: Any?)

enum class Status { SUCCESS, LOADING, ERROR }