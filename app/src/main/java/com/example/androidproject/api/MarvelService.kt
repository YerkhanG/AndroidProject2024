package com.example.androidproject.api

import com.example.androidproject.model.CharacterResponse
import com.example.androidproject.model.ComicsData
import com.example.androidproject.model.ComicsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val TIMESTAMP = "1681802982683"
const val API_KEY = "b0b2a8da53f5cbd179b428085e055bdc"
const val HASH = "57a41603f9f5df3be8c5cf9ab05fe412"

interface MarvelService {
    @GET("characters")
    fun getCharacters(
        @Query("ts") ts: String = TIMESTAMP,
        @Query("apikey") apiKey: String = API_KEY,
        @Query("hash") hash: String = HASH,
        @Query("limit") limit: Int = 50,
        @Query("series") series: String = "12429,548,354,1991"
    ): Call<CharacterResponse>
    @GET("comics")
    fun getComics(
        @Query("ts") ts: String = TIMESTAMP,
        @Query("apikey") apiKey: String = API_KEY,
        @Query("hash") hash: String = HASH,
        @Query("limit") limit: Int = 50,
    ): Call<ComicsResponse>
}