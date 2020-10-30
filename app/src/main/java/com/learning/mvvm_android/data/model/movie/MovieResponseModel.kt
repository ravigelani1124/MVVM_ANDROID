package com.interview.tmdb_mvc.model.movie

import com.learning.mvvm_android.data.model.movie.MovieResult

data class MovieResponseModel(
    val page: Int,
    val results: List<MovieResult>,
    val total_pages: Int,
    val total_results: Int
)