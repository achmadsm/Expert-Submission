package com.example.submission.core.domain.usecase

import androidx.lifecycle.LiveData
import com.example.submission.core.data.Resource
import com.example.submission.core.domain.model.Movie

interface MovieUseCase {
    fun getAllMovie(): LiveData<Resource<List<Movie>>>
    fun getFavoriteMovie(): LiveData<List<Movie>>
    fun setFavoriteMovie(movie: Movie, state: Boolean)
}