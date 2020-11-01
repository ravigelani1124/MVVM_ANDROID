package com.learning.data.repository

import MockWebServerUtils
import com.learning.data.service.MovieService
import com.learning.domain.model.Error
import com.learning.domain.model.Movie
import com.learning.domain.model.PopularMoviesResult
import com.learning.domain.repository.MovieRepository
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class MovieRepositoryTest {

    private lateinit var movieRepository: MovieRepository
    private var mockWebServer = MockWebServer()

    private val error = Error(7, "Invalid API key: You must be granted a valid key.")
    private val movies = listOf(
        Movie(
            adult = false,
            backdropPath = "/m7QpUAeI2xTCJyAVl9J9z5dBTSb.jpg",
            genreIds = listOf(28, 27, 878),
            id = 722603,
            originalLanguage = "en",
            originalTitle = "Battlefield 2025",
            overview = "Weekend campers, an escaped convict, young lovers and a police officer experience a night of terror when a hostile visitor from another world descends on a small Arizona town.",
            popularity = 357.955,
            posterPath = "/w6e0XZreiyW4mGlLRHEG8ipff7b.jpg",
            releaseDate = "2020-07-07",
            title = "Battlefield 2025",
            video = false,
            voteAverage = 5.7,
            voteCount = 76
        ), Movie(
            adult = false,
            backdropPath = "/4gKyQ1McHa8ZKDsYoyKQSevF01J.jpg",
            genreIds = listOf(
                35,
                10751,
                18
            ),
            id = 425001,
            originalLanguage = "en",
            originalTitle = "The War with Grandpa",
            overview = "Sixth-grader Peter is pretty much your average kid—he likes gaming, hanging with his friends and his beloved pair of Air Jordans. But when his recently widowed grandfather Ed  moves in with Peter’s family, the boy is forced to give up his most prized possession of all, his bedroom. Unwilling to let such an injustice stand, Peter devises a series of increasingly elaborate pranks to drive out the interloper, but Grandpa Ed won’t go without a fight.",
            popularity = 322.048,
            posterPath = "/ltyARDw2EFXZ2H2ERnlEctXPioP.jpg",
            releaseDate = "2020-08-27",
            title = "The War with Grandpa",
            video = false,
            voteAverage = 6.2,
            voteCount = 96
        )
    )

    @Before
    fun setup() {
        mockWebServer.url("")
        movieRepository = MovieRepositoryImpl(
            Retrofit.Builder()
                .baseUrl(mockWebServer.url(""))
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(MovieService::class.java)
        )
    }

    @Test
    fun `when 200 then returns PopularMovieResult success`() {
        runBlocking {
            mockHttpResponse("popular-movies-success.json", 200)
            val result = movieRepository.getPopularMovies()
            Assert.assertEquals(PopularMoviesResult.Success(movies), result)
        }
    }


    @Test
    fun `when 401 then returns PopularMovieResult failure`() {
        runBlocking {
            mockHttpResponse("popular-movies-failure.json", 401)
            val result = movieRepository.getPopularMovies()
            Assert.assertEquals(PopularMoviesResult.UnAuthorised(error), result)
        }
    }

    private fun mockHttpResponse(fileName: String? = null, responseCode: Int? = null) {
        return mockWebServer.enqueue(
            MockWebServerUtils.getMockedHttpResponse(fileName, responseCode)
        )
    }
}