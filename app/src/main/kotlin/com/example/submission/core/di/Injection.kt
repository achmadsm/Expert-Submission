package com.example.submission.core.di

import android.content.Context
import com.example.submission.core.data.MovieRepository
import com.example.submission.core.data.source.local.LocalDataSource
import com.example.submission.core.data.source.local.room.MovieDatabase
import com.example.submission.core.data.source.remote.RemoteDataSource
import com.example.submission.core.data.source.remote.network.ApiConfig
import com.example.submission.core.domain.repository.IMovieRepository
import com.example.submission.core.domain.usecase.MovieInteractor
import com.example.submission.core.domain.usecase.MovieUseCase
import com.example.submission.core.utils.AppExecutors

object Injection {
    private fun provideRepository(context: Context): IMovieRepository {
        val database = MovieDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.MovieDao())
        val appExecutors = AppExecutors()

        return MovieRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideMovieUseCase(context: Context): MovieUseCase {
        val repository = provideRepository(context)
        return MovieInteractor(repository)
    }
}