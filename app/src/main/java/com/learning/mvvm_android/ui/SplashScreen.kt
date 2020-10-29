package com.learning.mvvm_android.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learning.mvvm_android.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
    }
}