package com.example.core.data.source.remote.network

import com.example.core.BuildConfig
import com.example.core.data.source.remote.response.ListMovieResponse
import retrofit2.http.GET

const val apiKey = BuildConfig.API_KEY

interface ApiService {
    @GET("movie/now_playing?api_key=$apiKey")
    suspend fun getList(): ListMovieResponse
}