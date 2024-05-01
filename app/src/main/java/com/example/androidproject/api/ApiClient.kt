package com.example.androidproject.api

import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com/v1/public/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val instance = retrofit.create(NewsService::class.java)
    val instanceOfComics = retrofit.create(ComicsService::class.java)
}