package com.example.mygallery.network.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResponse(
    @Json(name = "total_pages") val pagesNumber: Int? = null,
    @Json(name = "results") val results: List<ImageResponse>? = null
)
