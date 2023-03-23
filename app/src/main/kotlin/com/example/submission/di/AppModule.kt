package com.example.submission.di

import com.example.submission.core.domain.usecase.MovieInteractor
import com.example.submission.core.domain.usecase.MovieUseCase
import com.example.submission.detail.DetailMovieViewModel
import com.example.submission.favorite.FavoriteViewModel
import com.example.submission.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }
}