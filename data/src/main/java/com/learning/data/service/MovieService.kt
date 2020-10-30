package com.learning.data.service

import com.google.gson.JsonObject
import com.learning.data.model.MoviesData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MovieService {

    @GET("3/movie/popular")
    suspend fun getPopularMovieList(
        @Query("api_key") api_key: String,
        @Query("page") page: Int
    ): Response<MoviesData>

    @GET("3/configuration")
    fun configuration(
        @Query("api_key") api_key: String,
    ): Call<JsonObject>

}