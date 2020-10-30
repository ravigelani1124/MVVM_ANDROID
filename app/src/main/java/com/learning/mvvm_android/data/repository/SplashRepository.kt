package com.learning.mvvm_android.data.repository

import com.learning.mvvm_android.data.api.ApiHelper
import com.learning.mvvm_android.data.model.configuration.ConfigurationResponseModel

class SplashRepository(private val apiHelper: ApiHelper) {

    suspend fun configuration(id:String): ConfigurationResponseModel {
       return apiHelper.getConfiguration(id)
    }
}