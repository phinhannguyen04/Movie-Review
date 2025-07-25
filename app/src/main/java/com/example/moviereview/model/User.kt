package com.example.moviereview.model

import androidx.annotation.DrawableRes

data class User(
    val id: Int,
    val name: String,
    @DrawableRes val imageRes: Int,
)
