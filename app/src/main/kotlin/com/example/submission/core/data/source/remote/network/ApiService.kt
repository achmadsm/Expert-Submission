package com.example.submission.core.data.source.remote.network

import com.example.submission.core.data.source.remote.response.ListMovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("movie/now_playing?api_key=2174d146bb9c0eab47529b2e77d6b526")
    fun getList(): Call<ListMovieResponse>
}