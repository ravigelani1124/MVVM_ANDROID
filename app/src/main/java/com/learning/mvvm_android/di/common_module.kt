package com.learning.mvvm_android.di

import com.learning.mvvm_android.BuildConfig
import com.learning.mvvm_android.data.api.ApiHelper
import com.learning.mvvm_android.data.api.ApiService
import com.learning.mvvm_android.ui.main.viewmodel.HomeScreenViewModel
import com.learning.mvvm_android.ui.main.viewmodel.SplashViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.compat.ViewModelCompat.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

 internal val common_module= module{

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor { chain ->
                val originalRequest = chain.request()
                val requestBuilder = originalRequest.newBuilder()
                    .method(originalRequest.method, originalRequest.body)
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            .addNetworkInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .addHeader("Accept", "application/json")
                chain.proceed(requestBuilder.build())
            }
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory {
        ApiHelper(get())
    }

    single {
        get<Retrofit>().create(ApiService::class.java)
    }
}