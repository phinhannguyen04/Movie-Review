package com.example.moviereview.model

import androidx.annotation.DrawableRes

data class MovieDetails(
    val id: Int,
    val title: String,
    val genres: List<String>,
    val year: String,
    val language: String,
    var rating: String,
    val description: String,
    @DrawableRes val imageRes: Int,
    var reviews: String = ""
)