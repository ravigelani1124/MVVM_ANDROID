package com.learning.domain.repository

import com.learning.domain.model.PopularMoviesResult

interface MovieRepository {

    suspend fun getPopularMovies(): PopularMoviesResult
}