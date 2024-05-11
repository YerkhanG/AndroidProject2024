package com.example.androidproject.model

data class ComicsResponse(
    val code: Int,
    val status: String,
    val data: ComicsData
)