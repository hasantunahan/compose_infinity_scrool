package com.example.compose_marvel.network

import com.example.compose_marvel.network.model.CharacterResponseModel
import com.example.compose_marvel.network.response.PaginationModel
import com.example.compose_marvel.network.response.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {

    @GET(ApiPath.character + ApiPath.authParams)
    suspend fun getCharacters(
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?,
        @Query("name") name: String?,
        @Query("series") series: Int?,
        @Query("comics") comics: Int?,
    ): ResponseModel<PaginationModel<CharacterResponseModel>>;

}