package com.learning.domain.model

sealed class PopularMoviesResult {

    data class Success(val movies : List<Movie>) : PopularMoviesResult()

    data class UnAuthorised(val error: Error?) : PopularMoviesResult()

    data class NotFound(val error: Error?) : PopularMoviesResult()

    object EmptyListError:PopularMoviesResult()

    object UnKnownError:PopularMoviesResult()
}