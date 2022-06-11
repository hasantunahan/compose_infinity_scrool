package com.example.compose_marvel.network

object ApiPath {
    private const val apiKey: String = "bfa1f5b14bff3bbf9cd292071f7e3e60";
    private const val hash: String = "3bed59c0cf4f292c7d84815cc9e6d6fc";
    const val baseUrl: String = "https://gateway.marvel.com/v1/public/";
    const val authParams: String = "?ts=1&apikey=$apiKey&hash=$hash";
    const val character: String = "characters";
    const val comics: String = "comics";
}