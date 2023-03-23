package com.example.submission.favorite

import androidx.lifecycle.ViewModel
import com.example.submission.core.domain.usecase.MovieUseCase

class FavoriteViewModel(movieUseCase: MovieUseCase):ViewModel() {
    val favoriteMovie = movieUseCase.getFavoriteMovie()
}