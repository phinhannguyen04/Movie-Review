package com.example.moviereview.viewModel

import androidx.lifecycle.ViewModel
import com.example.moviereview.data.MovieDataSource.movieData
import com.example.moviereview.data.thanhda
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter

class MainViewModel : ViewModel() {

    private val _movieState = MutableStateFlow(movieData)
    val movieState = _movieState.asStateFlow()

    private val _movieRating = MutableStateFlow(0)
    val movieRating = _movieRating.asStateFlow()

    private val _currentUser = MutableStateFlow(thanhda)
    val currentUser = _currentUser.asStateFlow()

    private val _movieReview = MutableStateFlow("")
    val movieReview = _movieReview.asStateFlow()

    fun updateMovieRating(rating: Int) {
        _movieRating.value = rating
    }

    fun updateMovieComment(review: String) {
        _movieReview.value = review
    }

    fun loadMovieForReview(id: Int) {
        val movie = _movieState.value.find { it.id == id }
        if (movie != null) {
            _movieRating.value = movie.rating.toIntOrNull() ?: 0
            _movieReview.value = movie.reviews
        }
    }

    fun updateMovie(id: Int) {
        val currentMovies = _movieState.value
        val index = currentMovies.indexOfFirst { it.id == id }

        if (index != -1) {
            val oldMovie = currentMovies[index]
            val updatedMovie = oldMovie.copy(
                rating = _movieRating.value.toString(),
                reviews = _movieReview.value
            )
            val updatedList = currentMovies.toMutableList().apply {
                this[index] = updatedMovie
            }.toList()
            _movieState.value = updatedList
        }
    }
}