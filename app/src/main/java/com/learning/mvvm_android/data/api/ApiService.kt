package com.learning.mvvm_android.data.api

import com.learning.mvvm_android.data.model.configuration.ConfigurationResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("3/configuration")
    suspend fun configuration(
        @Query("api_key") api_key: String,
    ):  Response<ConfigurationResponseModel>

}