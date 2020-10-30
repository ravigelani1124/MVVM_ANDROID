package com.learning.mvvm_android.data.api

import com.learning.mvvm_android.data.model.configuration.ConfigurationResponseModel


class ApiHelper(private val apiService: ApiService) {

    suspend fun getConfiguration(id:String): ConfigurationResponseModel {
     return apiService.configuration(id)
    }
}