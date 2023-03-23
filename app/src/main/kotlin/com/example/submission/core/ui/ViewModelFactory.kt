package com.example.submission.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.submission.core.di.Injection
import com.example.submission.core.domain.usecase.MovieUseCase
import com.example.submission.detail.DetailMovieViewModel
import com.example.submission.favorite.FavoriteViewModel
import com.example.submission.home.HomeViewModel

class ViewModelFactory private constructor(private val movieUseCase: MovieUseCase) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = when {
        modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
            HomeViewModel(movieUseCase) as T
        }
        modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
            FavoriteViewModel(movieUseCase) as T
        }
        modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
            DetailMovieViewModel(movieUseCase) as T
        }
        else -> throw Throwable("Unknown ViewModel Class: " + modelClass.name)
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(
                    Injection.provideMovieUseCase(context)
                )
            }
    }
}