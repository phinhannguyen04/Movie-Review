package com.example.moviereview.data

import com.example.moviereview.model.CastMember
import com.example.moviereview.model.MovieDetails
import com.example.moviereview.model.Rating
import com.example.moviereview.model.Review
import com.example.moviereview.model.SimilarMovie

val listMovieDetails = mutableListOf<MovieDetails>(
    MovieDetails(
        title = "Saving Private Ryan",
        rating = Rating(score = 8.6, source = "IMDb", percentage = 94),
        tags = listOf("War", "Drama", "Action"),
        year = 1998,
        language = "English",
        ratingMPAA = "R",
        description = "During the Normandy Invasion of WWII, Captain John Miller is assigned the task of searching for Private James Ryan, whose three brothers have already been killed in the war.",
        cast = listOf(
            CastMember(name = "Tom Hanks", imageUrl = 0),
            CastMember(name = "Tom Sizemore", imageUrl = 0),
            CastMember(name = "Vin Diesel", imageUrl = 0)
        ),
        reviews = listOf(
            Review(author = "Nischal", text = "absolutely lost my sh!t when Vin Diesel showed up", stars = 5),
            Review(author = "Nischal", text = "war is bad. tom hanks is good.", stars = 4)
        ),
        similarMovies = listOf(
            SimilarMovie(title = "Dunkirk", imageUrl = 0),
            SimilarMovie(title = "Band of Brothers", imageUrl = 0),
            SimilarMovie(title = "Fury", imageUrl = 0)
        )
    ),

    MovieDetails(
        title = "The Shawshank Redemption",
        rating = Rating(score = 9.3, source = "IMDb", percentage = 98),
        tags = listOf("Drama"),
        year = 1994,
        language = "English",
        ratingMPAA = "R",
        description = "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
        cast = listOf(
            CastMember(name = "Tim Robbins"),
            CastMember(name = "Morgan Freeman")
        ),
        reviews = listOf(
            Review(author = "MovieFanatic", text = "A timeless masterpiece! Morgan Freeman's narration is iconic.", stars = 5),
            Review(author = "FilmBuff", text = "One of the greatest films ever made. Pure genius.", stars = 5)
        ),
        similarMovies = listOf(
            SimilarMovie(title = "The Green Mile"),
            SimilarMovie(title = "Forrest Gump")
        )
    ),

    MovieDetails(
        title = "Inception",
        rating = Rating(score = 8.8, source = "IMDb", percentage = 90),
        tags = listOf("Action", "Sci-Fi", "Thriller"),
        year = 2010,
        language = "English",
        ratingMPAA = "PG-13",
        description = "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
        cast = listOf(
            CastMember(name = "Leonardo DiCaprio"),
            CastMember(name = "Joseph Gordon-Levitt"),
            CastMember(name = "Elliot Page")
        ),
        reviews = listOf(
            Review(author = "SciFiGuru", text = "Mind-bending and visually stunning! A true modern classic.", stars = 5),
            Review(author = "Dreamer", text = "Left me thinking for days. So complex and well-executed.", stars = 4)
        ),
        similarMovies = listOf(
            SimilarMovie(title = "The Matrix"),
            SimilarMovie(title = "Interstellar")
        )
    )
)