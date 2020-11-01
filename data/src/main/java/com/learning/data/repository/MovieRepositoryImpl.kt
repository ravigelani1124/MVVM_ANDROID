package com.learning.data.repository

import com.google.gson.Gson
import com.learning.data.model.map
import com.learning.data.service.MovieService
import com.learning.domain.model.Error
import com.learning.domain.model.PopularMoviesResult
import com.learning.domain.repository.MovieRepository
import org.json.JSONObject

internal class MovieRepositoryImpl(private val movieService: MovieService) : MovieRepository {

    override suspend fun getPopularMovies(): PopularMoviesResult {
        val response = movieService.getPopularMovieList("f05c3b8d922103b63e4eea496cf3d1f7", 3)
        return when (response.code()) {

            200 -> {
                val result = response.body()?.results?.map {
                    it.map()
                }
                if (result == null) {
                    PopularMoviesResult.EmptyListError
                } else {
                    PopularMoviesResult.Success(result)
                }
            }

            401 -> {
                val error = Gson().fromJson(
                    JSONObject(response.errorBody().toString()).toString(),
                    Error::class.java)
                PopularMoviesResult.UnAuthorised(error)
            }
            404 -> {
                val error = Gson().fromJson(
                    JSONObject(response.errorBody().toString()).toString(),
                    Error::class.java)
                PopularMoviesResult.UnAuthorised(error)
            }
            else -> {
                PopularMoviesResult.UnKnownError
            }
        }
    }
}