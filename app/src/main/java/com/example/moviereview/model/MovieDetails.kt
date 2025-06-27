package com.example.moviereview.model

data class MovieDetails(
    val title: String,
    val rating: Rating,
    val tags: List<String>,
    val year: Int,
    val language: String,
    val ratingMPAA: String, // Rating (MPAA rating like R, PG-13, etc.)
    val description: String,
    val cast: List<CastMember>,
    val reviews: List<Review>,
    val similarMovies: List<SimilarMovie>
)
