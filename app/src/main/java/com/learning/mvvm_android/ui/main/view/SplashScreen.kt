package com.learning.mvvm_android.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.google.gson.JsonObject
import com.learning.mvvm_android.R
import com.learning.mvvm_android.data.api.ApiHelper
import com.learning.mvvm_android.data.api.RetrofitBuilder
import com.learning.mvvm_android.data.model.configuration.ConfigurationResponseModel
import com.learning.mvvm_android.databinding.ActivitySplashScreenBinding
import com.learning.mvvm_android.ui.base.SplashViewModelFactory
import com.learning.mvvm_android.ui.main.viewmodel.SplashViewModel
import com.learning.mvvm_android.util.Status
import com.learning.mvvm_android.util.toast

class SplashScreen : AppCompatActivity() {

    private lateinit var splashViewModel: SplashViewModel
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViewModel()
        setupObservers()
    }

    private fun setupViewModel() {
        binding=DataBindingUtil.setContentView(this,R.layout.activity_splash_screen)
        splashViewModel= ViewModelProviders.of(this,SplashViewModelFactory(ApiHelper(RetrofitBuilder.apiService)))
            .get(SplashViewModel::class.java)
    }

    private fun setupObservers() {
        splashViewModel.getConfiguration(resources.getString(R.string.api_key)).observe(this,
            {
                it?.let {
                    resource ->
                    when(resource.status){

                        Status.LOADING->{
                        }
                        Status.SUCCESS->{
                            toast("Success")
                            //resource.data?.let { configuration -> retrieveConfiguration(configuration) }
                            binding.pbProgress.visibility=View.GONE
                        }
                        Status.ERROR->{
                            toast("Error")
                            binding.pbProgress.visibility=View.GONE
                        }
                    }
                }
            })
    }

    private fun retrieveConfiguration(configuration: ConfigurationResponseModel) {
        toast(configuration.images.base_url)
    }
}