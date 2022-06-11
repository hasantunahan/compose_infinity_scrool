package com.example.compose_marvel.network.response

data class ResponseModel<T>(
    val code: Int?,
    val data: T?,
    val status: String?
)