package com.learning.mvvm_android.data.api

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("3/configuration")
    suspend fun configuration(
        @Query("api_key") api_key: String,
    ): Call<JsonObject>

}