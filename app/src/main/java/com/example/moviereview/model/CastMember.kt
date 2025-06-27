package com.example.moviereview.model

import androidx.annotation.DrawableRes

data class CastMember(
    val name: String,
    @DrawableRes val imageUrl: Int = 0
)
