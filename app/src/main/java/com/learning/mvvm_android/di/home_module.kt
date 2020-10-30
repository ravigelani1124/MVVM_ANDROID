package com.learning.mvvm_android.di

import com.learning.mvvm_android.data.repository.HomeRepository
import com.learning.mvvm_android.ui.main.viewmodel.HomeScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val home_module = module {

    viewModel { HomeScreenViewModel(get()) }
    factory {
        HomeRepository(get())
    }

}