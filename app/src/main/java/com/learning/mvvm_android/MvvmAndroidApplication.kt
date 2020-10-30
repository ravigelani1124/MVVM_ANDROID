package com.learning.mvvm_android

import android.app.Application
import com.learning.mvvm_android.di.common_module
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MvvmAndroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            // Koin Android logger
            androidLogger()
            androidContext(this@MvvmAndroidApplication)
            modules(listOf(common_module))
        }
    }
}
