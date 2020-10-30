package com.learning.mvvm_android.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getConfiguration() = apiService.configuration()
}