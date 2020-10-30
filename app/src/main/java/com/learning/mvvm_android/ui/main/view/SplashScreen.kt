package com.learning.mvvm_android.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.learning.mvvm_android.R
import com.learning.mvvm_android.data.api.ApiHelper
import com.learning.mvvm_android.data.api.RetrofitBuilder
import com.learning.mvvm_android.data.model.configuration.ConfigurationResponseModel
import com.learning.mvvm_android.databinding.ActivitySplashScreenBinding
import com.learning.mvvm_android.ui.base.ViewModelFactory
import com.learning.mvvm_android.ui.main.viewmodel.SplashViewModel
import com.learning.mvvm_android.util.Status
import com.learning.mvvm_android.util.hide
import com.learning.mvvm_android.util.show
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
        splashViewModel= ViewModelProviders.of(this,ViewModelFactory(ApiHelper(RetrofitBuilder.apiService)))
            .get(SplashViewModel::class.java)
    }

    private fun setupObservers() {
        splashViewModel.getConfiguration(resources.getString(R.string.api_key)).observe(this,
            {
                it?.let {
                    resource ->
                    when(resource.status){

                        Status.LOADING->{
                            binding.pbProgress.show()
                        }
                        Status.SUCCESS->{
                            toast("Success")
                            binding.pbProgress.hide()
                            //resource.data?.let { configuration -> retrieveConfiguration(configuration) }
                        }
                        Status.ERROR->{
                            toast("Error")
                            binding.pbProgress.hide()
                        }
                    }
                }
            })
    }

    private fun retrieveConfiguration(configuration: ConfigurationResponseModel) {
        toast(configuration.images.base_url)
    }
}