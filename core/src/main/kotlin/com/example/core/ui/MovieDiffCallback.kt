package com.example.core.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.core.domain.model.Movie

class MovieDiffCallback(
    private val mOldMovieList: List<Movie>,
    private val mNewMovieList: List<Movie>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return mOldMovieList.size
    }

    override fun getNewListSize(): Int {
        return mNewMovieList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldMovieList[oldItemPosition].id == mNewMovieList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldMovie = mOldMovieList[oldItemPosition]
        val newMovie = mNewMovieList[newItemPosition]
        return oldMovie.title == newMovie.title && oldMovie.overview == newMovie.overview && oldMovie.posterPath == newMovie.posterPath
    }
}