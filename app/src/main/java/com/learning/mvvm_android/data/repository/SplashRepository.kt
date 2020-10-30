package com.learning.mvvm_android.data.repository

import com.learning.mvvm_android.data.api.ApiService
import com.learning.mvvm_android.data.model.configuration.ConfigurationResponseModel
import retrofit2.Response

class SplashRepository(private val apiService: ApiService) {

    suspend fun configuration(id:String): Response<ConfigurationResponseModel> {
       return apiService.configuration(id)
    }
}