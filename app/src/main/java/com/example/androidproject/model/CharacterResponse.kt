package com.example.androidproject.model

data class CharacterResponse(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: CharacterData
)

data class CharacterData(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<Character>
)

data class Character(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnail: Thumbnail,
    val resourceURI: String,
    val comics: ComicList,
    val series: SeriesList,
    val stories: StoryList,
    val events: EventList,
    val urls: List<Url>
)

data class Thumbnail(
    val path: String,
    val extension: String
)

data class ComicList(
    val available: Int,
    val collectionURI: String,
    val items: List<ComicSummary>,
    val returned: Int
)

data class ComicSummary(
    val resourceURI: String,
    val name: String
)

data class SeriesList(
    val available: Int,
    val collectionURI: String,
    val items: List<SeriesSummary>,
    val returned: Int
)

data class SeriesSummary(
    val resourceURI: String,
    val name: String
)

data class StoryList(
    val available: Int,
    val collectionURI: String,
    val items: List<StorySummary>,
    val returned: Int
)

data class StorySummary(
    val resourceURI: String,
    val name: String,
    val type: String
)

data class EventList(
    val available: Int,
    val collectionURI: String,
    val items: List<EventSummary>,
    val returned: Int
)

data class EventSummary(
    val resourceURI: String,
    val name: String
)

data class Url(
    val type: String,
    val url: String
)
