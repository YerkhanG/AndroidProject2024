package com.example.androidproject.model

data class ComicsApi (
    val id : Int ,
    val title : String ,
    val description : String,
    val images : List<String>
)