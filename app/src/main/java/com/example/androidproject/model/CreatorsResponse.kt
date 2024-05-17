package com.example.androidproject.model

data class CreatorsResponse(
  val code: Int,
  val status: String,
  val copyright: String,
  val attributionText: String,
  val attributionHTML: String,
  val etag: String,
  val data: CreatorsData
)
data class CreatorsData(
  val offset: Int,
  val limit: Int,
  val total: Int,
  val count: Int,
  val results: List<Creator>
)
data class Creator(
  val id: Int,
  val firstName: String,
  val middleName: String?,
  val lastName: String,
  val suffix: String?,
  val fullName: String,
  val modified: String,
  val resourceURI: String,
  val urls: List<CreatorsUrl>,
  val thumbnail: Image,
  val series: SeriesLis,
  val stories: StoryLis,
  val comics: ComicLis,
  val events: EventLis
)

data class CreatorsUrl(
  val type: String,
  val url: String
)

data class Image(
  val path: String,
  val extension: String
)

data class SeriesLis(
  val available: Int,
  val returned: Int,
  val collectionURI: String,
  val items: List<SeriesSum>
)

data class SeriesSum(
  val resourceURI: String,
  val name: String
)

data class StoryLis(
  val available: Int,
  val returned: Int,
  val collectionURI: String,
  val items: List<StorySum>
)

data class StorySum(
  val resourceURI: String,
  val name: String,
  val type: String
)

data class ComicLis(
  val available: Int,
  val returned: Int,
  val collectionURI: String,
  val items: List<ComicSum>
)

data class ComicSum(
  val resourceURI: String,
  val name: String
)

data class EventLis(
  val available: Int,
  val returned: Int,
  val collectionURI: String,
  val items: List<EventSum>
)

data class EventSum(
  val resourceURI: String,
  val name: String
)
