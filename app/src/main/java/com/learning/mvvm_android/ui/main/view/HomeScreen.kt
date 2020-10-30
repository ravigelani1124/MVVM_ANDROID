package com.learning.mvvm_android.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.learning.mvvm_android.R
import com.learning.mvvm_android.databinding.ActivityHomeScreenBinding
import com.learning.mvvm_android.di.splash_module
import com.learning.mvvm_android.ui.main.viewmodel.HomeScreenViewModel
import org.koin.core.context.loadKoinModules
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeScreen : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding
    private val viewModel: HomeScreenViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(splash_module)
        setupViewModel()
    }

    private fun setupViewModel() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_screen)
    }
}