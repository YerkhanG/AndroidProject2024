package com.example.androidproject.api

import com.example.androidproject.model.Comics
import com.example.androidproject.model.News
import retrofit2.Call
import retrofit2.http.GET

interface ComicsService {
    @GET("comics?ts=1681802982683&apikey=b0b2a8da53f5cbd179b428085e055bdc&hash=57a41603f9f5df3be8c5cf9ab05fe412")
    fun fetchComicsList(): Call<List<Comics>>
}