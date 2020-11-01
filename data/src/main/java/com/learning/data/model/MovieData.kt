package com.learning.data.model

import com.google.gson.annotations.SerializedName
import com.learning.domain.model.Movie

internal data class MovieData(
    @SerializedName("adult")
    val adult: Boolean?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("genre_ids")
    val genreIds: List<Int>?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("original_language")
    val originalLanguage: String?,
    @SerializedName("original_title")
    val originalTitle: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("video")
    val video: Boolean?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("vote_count")
    val voteCount: Int?
)

internal fun MovieData.map() : Movie {
    return Movie(
        adult=this.adult,
        backdropPath=this.backdropPath,
        genreIds=this.genreIds,
        id=this.id,
        originalLanguage=this.originalLanguage,
        originalTitle=this.originalTitle,
        overview=this.overview,
        popularity=this.popularity,
        posterPath=this.posterPath,
        releaseDate=this.releaseDate,
        title=this.title,
        video=this.video,
        voteAverage=this.voteAverage,
        voteCount=this.voteCount
    )
}
