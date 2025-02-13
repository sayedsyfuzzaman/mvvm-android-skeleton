package com.syfuzzaman.mvvm_android_skeleton.di

import com.syfuzzaman.mvvm_android_skeleton.BuildConfig
import com.syfuzzaman.mvvm_android_skeleton.data.network.api.InternalApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.nerdythings.okhttp.profiler.OkHttpProfilerInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY // Log response body
        }
        val clientBuilder = OkHttpClient.Builder().apply {
            retryOnConnectionFailure(true)
            if (BuildConfig.DEBUG ) {
                addInterceptor(loggingInterceptor)
                addInterceptor(OkHttpProfilerInterceptor())
            }
        }
        return clientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideApiService(
        okHttpClient: OkHttpClient
    ): InternalApi =
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(InternalApi::class.java)
}