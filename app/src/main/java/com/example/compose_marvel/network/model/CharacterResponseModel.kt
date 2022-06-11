package com.example.compose_marvel.network.model


data class CharacterResponseModel(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnail: Thumbnail,
    val comics: Comics,
)

data class Thumbnail(
    val path: String,
    val extension: String
)

data class Items(
    val resourceURI: String,
    val name: String,
    val type: String,
)

data class Comics(
    val available: Int,
    val collectionURI: String,
    val items: List<Items>?,
    val returned: Int
)
