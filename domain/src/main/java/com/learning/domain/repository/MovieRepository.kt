package com.learning.domain.repository

import com.learning.domain.model.Movie

interface MovieRepository  {

    fun getPopularMovies():List<Movie>
}