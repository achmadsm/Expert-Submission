package com.example.submission.core.domain.repository

import androidx.lifecycle.LiveData
import com.example.submission.core.data.Resource
import com.example.submission.core.domain.model.Movie

interface IMovieRepository {
    fun getAllMovie(): LiveData<Resource<List<Movie>>>
    fun getFavoriteMovie(): LiveData<List<Movie>>
    fun setFavoriteMovie(movie: Movie, state: Boolean)
}