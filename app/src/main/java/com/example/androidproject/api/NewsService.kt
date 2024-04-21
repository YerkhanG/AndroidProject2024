package com.example.androidproject.api

import com.example.androidproject.model.News
import retrofit2.Call
import retrofit2.http.GET

interface NewsService {
    @GET("getNewsOnDemand3/?limit=10&offset=0")
    fun fetchNewsList(): Call<List<News>>
}