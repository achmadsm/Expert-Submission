package com.example.submission.detail

import androidx.lifecycle.ViewModel
import com.example.submission.core.domain.model.Movie
import com.example.submission.core.domain.usecase.MovieUseCase

class DetailMovieViewModel(private var movieUseCase: MovieUseCase) : ViewModel() {
    fun setFavoriteMovie(movie: Movie, newStatus: Boolean) =
        movieUseCase.setFavoriteMovie(movie, newStatus)
}