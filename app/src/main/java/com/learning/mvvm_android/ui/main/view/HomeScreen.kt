package com.learning.mvvm_android.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.learning.mvvm_android.R
import com.learning.mvvm_android.data.api.ApiHelper
import com.learning.mvvm_android.data.api.RetrofitBuilder
import com.learning.mvvm_android.databinding.ActivityHomeScreenBinding
import com.learning.mvvm_android.ui.base.ViewModelFactory
import com.learning.mvvm_android.ui.main.viewmodel.HomeScreenViewModel

class HomeScreen : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding
    private lateinit var viewModel: HomeScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
    }

    private fun setupViewModel() {
     binding= DataBindingUtil.setContentView(this,R.layout.activity_home_screen)
     viewModel = ViewModelProviders.of(this,ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))).get(HomeScreenViewModel::class.java)
    }
}