package com.example.core.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.core.BuildConfig
import com.example.core.R

fun ImageView.loadImage(endPoint: String) {
    val imageUrl = BuildConfig.IMAGE_URL
    Glide.with(this.context)
        .load("$imageUrl/$endPoint")
        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
        .error(R.drawable.ic_error)
        .into(this)

}