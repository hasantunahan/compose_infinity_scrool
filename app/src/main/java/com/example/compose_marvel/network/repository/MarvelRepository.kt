package com.example.compose_marvel.network.repository

import com.example.compose_marvel.network.MarvelApi
import com.example.compose_marvel.network.model.CharacterResponseModel
import com.example.compose_marvel.network.response.PaginationModel
import com.example.compose_marvel.network.response.ResponseModel
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


@ActivityScoped
class MarvelRepository @Inject constructor(
    private val api: MarvelApi
) {
    suspend fun getCharactersList(
        limit: Int,
        offset: Int,
        name: String?,
        series: Int?,
        comics: Int?,
    ): ResponseModel<PaginationModel<CharacterResponseModel>> {
        val response = try {
            api.getCharacters(limit, offset, name, series, comics)
        } catch (e: Exception) {
            return ResponseModel(null, null, null);
        }
        return response;
    }
}