package com.example.moviereview.viewModel

import androidx.lifecycle.ViewModel
import com.example.moviereview.data.movieData
import com.example.moviereview.model.MovieDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val _movieState = MutableStateFlow(movieData)
    val movieState = _movieState.asStateFlow()


    fun getMovie(id: Int): MovieDetails? {
        val movie = _movieState.value.find { it.id == id }
        return movie
    }

    /*
    * Đánh giá phim
    * */
    private val _movieRating = MutableStateFlow(0)
    val movieRating = _movieRating.asStateFlow()

    fun updateMovieRating(id: Int, rating: Int) {
        _movieState.value = _movieState.value.map { movie ->
            if (movie.id == id) {
                movie.copy(rating = rating.toString())
            } else {
                movie
            }
        }
    }

    private val _movieReview = MutableStateFlow("")
    val movieReview = _movieReview.asStateFlow()

    fun updateMovieComment(comment: String) {
        _movieReview.value = comment
        print(movieReview)
    }
}