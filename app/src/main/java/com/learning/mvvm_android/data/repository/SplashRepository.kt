package com.learning.mvvm_android.data.repository

import com.learning.mvvm_android.data.api.ApiHelper

class SplashRepository(private val apiHelper: ApiHelper) {

    suspend fun configuration() = apiHelper.getConfiguration()
}