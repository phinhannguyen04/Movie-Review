package com.example.moviereview.model

data class Rating(
    val score: Double,
    val source: String, // e.g., IMDb
    val percentage: Int // 94%
)
