package com.learning.mvvm_android.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.learning.mvvm_android.data.api.ApiHelper
import com.learning.mvvm_android.data.repository.HomeRepository
import com.learning.mvvm_android.data.repository.SplashRepository
import com.learning.mvvm_android.ui.main.viewmodel.HomeScreenViewModel
import com.learning.mvvm_android.ui.main.viewmodel.SplashViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SplashViewModel::class.java)) {
            return SplashViewModel(SplashRepository(apiHelper)) as T
        } else if (modelClass.isAssignableFrom(HomeScreenViewModel::class.java)){
            return HomeScreenViewModel(HomeRepository(apiHelper)) as T
        }
            throw IllegalArgumentException("Unknown class name")
    }
}