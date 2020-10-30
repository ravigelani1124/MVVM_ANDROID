package com.learning.mvvm_android.data.network

import com.learning.mvvm_android.util.TinyDb
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

interface ApiInterface {

    companion object {
        operator fun invoke(
                networkConnectionInterceptor: NetworkConnectionInterceptor
        ): ApiInterface {

            val okClient = OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .addInterceptor(networkConnectionInterceptor)
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

            return Retrofit.Builder()
                    .client(okClient)
                    .baseUrl(TinyDb.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiInterface::class.java)
        }
    }

}