package com.learning.mvvm_android.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.learning.mvvm_android.R
import com.learning.mvvm_android.data.model.configuration.ConfigurationResponseModel
import com.learning.mvvm_android.databinding.ActivitySplashScreenBinding
import com.learning.mvvm_android.di.splash_module
import com.learning.mvvm_android.ui.main.viewmodel.SplashViewModel
import com.learning.mvvm_android.util.Status
import com.learning.mvvm_android.util.hide
import com.learning.mvvm_android.util.show
import com.learning.mvvm_android.util.toast
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class SplashScreen : AppCompatActivity() {

    private val splashViewModel: SplashViewModel by viewModel()
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(splash_module)
        setupViewModel()
        setupObservers()
    }

    private fun setupViewModel() {
        binding=DataBindingUtil.setContentView(this,R.layout.activity_splash_screen)
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
                            resource.data?.let { configuration -> retrieveConfiguration(configuration) }
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
        binding.model=configuration
        toast(configuration.images.base_url)

    }
}