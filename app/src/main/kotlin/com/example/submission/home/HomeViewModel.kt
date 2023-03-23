package com.example.submission.home

import androidx.lifecycle.ViewModel
import com.example.submission.core.domain.usecase.MovieUseCase

class HomeViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val movie = movieUseCase.getAllMovie()
}