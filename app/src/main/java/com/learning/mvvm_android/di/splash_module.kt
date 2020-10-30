package com.learning.mvvm_android.di

import com.learning.mvvm_android.data.repository.SplashRepository
import com.learning.mvvm_android.ui.main.viewmodel.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val splash_module = module {

    viewModel { SplashViewModel(get()) }

    factory {
        SplashRepository(get())
    }
}