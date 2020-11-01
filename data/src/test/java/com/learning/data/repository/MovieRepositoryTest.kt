package com.learning.data.repository

import com.learning.data.service.MovieService
import com.learning.domain.repository.MovieRepository
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class MovieRepositoryTest {

    private lateinit var movieRepository: MovieRepository
    private var mockWebServer = MockWebServer()

    @Before
    fun setup() {
        movieRepository = MovieRepositoryImpl(
            Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(MovieService::class.java)
        )
    }

    @Test
    fun `when 200 then returns PopularMovieResult success`(){
        runBlocking {
            val result=movieRepository.getPopularMovies()
        }
    }
}