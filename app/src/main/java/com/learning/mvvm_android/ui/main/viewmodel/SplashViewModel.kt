package com.learning.mvvm_android.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.learning.mvvm_android.data.repository.SplashRepository
import com.learning.mvvm_android.util.Resource
import kotlinx.coroutines.Dispatchers

class SplashViewModel(private val splashRepository: SplashRepository) : ViewModel() {

    fun getConfiguration(id :String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = splashRepository.configuration(id)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}