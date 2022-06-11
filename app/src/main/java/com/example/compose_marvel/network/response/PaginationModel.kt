package com.example.compose_marvel.network.response

data class PaginationModel<T>(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<T>
);
