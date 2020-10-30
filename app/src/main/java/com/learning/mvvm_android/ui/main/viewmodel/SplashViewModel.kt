package com.learning.mvvm_android.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learning.mvvm_android.data.model.configuration.ConfigurationResponseModel
import com.learning.mvvm_android.data.repository.SplashRepository
import com.learning.mvvm_android.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

class SplashViewModel(private val splashRepository: SplashRepository) : ViewModel() {

    val liveData = MutableLiveData<Resource<ConfigurationResponseModel>>()

    fun getConfiguration(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            liveData.postValue(Resource.loading(data = null))

            val response = splashRepository.configuration(id)

            when (response.code()) {

                200 -> {
                    liveData.postValue(Resource.success(data = response.body()))
                }
                404 -> {
                    val jsonObject = JSONObject(response.errorBody()!!.string())
                    liveData.postValue(Resource.error(data = null, message = jsonObject.getString("message")))
                }
            }
        }
    }
}