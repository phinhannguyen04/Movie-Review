package com.example.moviereview.data

import com.example.moviereview.R
import com.example.moviereview.model.MovieDetails

object MovieDataSource {
    val movieData: List<MovieDetails> = listOf(
        MovieDetails(
            id = 1,
            title = "Inception",
            genres = listOf("Sci-Fi", "Action", "Thriller"),
            year = "2010",
            language = "English",
            rating = "4",
            description = "A thief who steals corporate secrets through use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
            imageRes = R.drawable.inception // Thay thế bằng ID ảnh thực của bạn
        ),
        MovieDetails(
            id = 2,
            title = "The Dark Knight",
            genres = listOf("Action", "Crime", "Drama"),
            year = "2008",
            language = "English",
            rating = "3",
            description = "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
            imageRes = R.drawable.the_dark_knight // Thay thế bằng ID ảnh thực của bạn
        ),
        MovieDetails(
            id = 3,
            title = "Interstellar",
            genres = listOf("Sci-Fi", "Drama", "Adventure"),
            year = "2014",
            language = "English",
            rating = "2",
            description = "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
            imageRes = R.drawable.interstellar // Thay thế bằng ID ảnh thực của bạn
        ),
        MovieDetails(
            id = 4,
            title = "The Shawshank Redemption",
            genres = listOf("Drama"),
            year = "1994",
            language = "English",
            rating = "1",
            description = "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.", // Mô tả mới
            imageRes = R.drawable.the_shawshank_redemption
        ),
        MovieDetails(
            id = 5,
            title = "Forrest Gump",
            genres = listOf("Drama", "Romance"),
            year = "1994",
            language = "English",
            rating = "0",
            description = "The presidencies of Kennedy and Johnson, the Vietnam War, the Watergate scandal and other historical events unfold from the perspective of an Alabama man with an IQ of 75, whose only desire is to be reunited with his childhood sweetheart.",
            imageRes = R.drawable.forrest_gump // Thay thế bằng ID ảnh thực của bạn
        )
    )
}