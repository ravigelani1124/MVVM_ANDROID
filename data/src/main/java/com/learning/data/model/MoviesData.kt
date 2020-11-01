package com.learning.data.model

import com.google.gson.annotations.SerializedName

internal data class MoviesData(

    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MovieData>,
    @SerializedName("totalPages")
    val totalPages: Int,
    @SerializedName("totalResults")
    val totalResults: Int
)