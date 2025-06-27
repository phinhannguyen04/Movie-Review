package com.example.moviereview.model

import androidx.annotation.DrawableRes

data class SimilarMovie(
    val title: String,
    @DrawableRes val imageUrl: Int = 0
)
