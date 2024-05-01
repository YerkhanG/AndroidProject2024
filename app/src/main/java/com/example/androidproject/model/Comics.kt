package com.example.androidproject.model

data class Comics (
    val id : Int ,
    val title : String ,
    val description : String,
    val images : List<String>
) {
    companion object{
        fun toComics(comicsApi: ComicsApi) = Comics(
            title = comicsApi.title,
            id = comicsApi.id,
            description =  comicsApi.description,
            images = comicsApi.images,
        )
    }
}
