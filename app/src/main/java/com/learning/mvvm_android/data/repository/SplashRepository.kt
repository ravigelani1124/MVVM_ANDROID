package com.learning.mvvm_android.data.repository

import com.learning.mvvm_android.data.api.ApiHelper

class SplashRepository(private val apiHelper: ApiHelper) {

    suspend fun configuration(id:String) {
        apiHelper.getConfiguration(id)
    }
}