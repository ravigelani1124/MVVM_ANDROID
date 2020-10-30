package com.learning.mvvm_android.data.model.configuration

import com.interview.tmdb_mvc.model.configuration.Images

data class ConfigurationResponseModel(
    val change_keys: List<String>,
    val images: Images
)