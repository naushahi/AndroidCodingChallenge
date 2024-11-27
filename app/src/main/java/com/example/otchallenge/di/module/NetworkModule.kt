package com.example.otchallenge.di.module

import com.example.otchallenge.data.remote.ApiService
import com.example.otchallenge.utils.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun getGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideOkhttpClient(
        interceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(Interceptor { chain: Interceptor.Chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Accept", "application/json")
                    .build()
                chain.proceed(request)
            }).build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideAPIService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}