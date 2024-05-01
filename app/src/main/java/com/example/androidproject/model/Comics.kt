package com.example.androidproject.model

data class Comics(
    val id: Int,
    val digitalId: Int,
    val title: String,
    val issueNumber: Int,
    val variantDescription: String,
    val description: String,
    val modified: String,
    val isbn: String,
    val upc: String,
    val diamondCode: String,
    val ean: String,
    val issn: String,
    val format: String,
    val pageCount: Int,
    val textObjects: List<Any>,
    val resourceURI: String,
    val urls: List<Url>,
    val series: Series,
    val variants: List<Variant>,
    val collections: List<Any>,
    val collectedIssues: List<Any>,
    val dates: List<Date>,
    val prices: List<Price>,
    val thumbnail: Thumbnail,
    val images: List<Any>,
    val creators: Creators,
    val characters: Characters,
    val stories: Stories,
    val events: Events
)

data class Series(
    val resourceURI: String,
    val name: String
)

data class Variant(
    val resourceURI: String,
    val name: String
)

data class Date(
    val type: String,
    val date: String
)

data class Price(
    val type: String,
    val price: Double
)

data class Creators(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)

data class Item(
    val resourceURI: String,
    val name: String,
    val role: String
)

data class Characters(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<Any>,
    val returned: Int
)
data class ComicsResponse(
    val code: Int,
    val status: String,
    val data: ComicsData
)

data class ComicsData(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<Comics>
)
