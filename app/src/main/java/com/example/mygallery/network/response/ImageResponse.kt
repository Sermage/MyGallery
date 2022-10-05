package com.example.mygallery.network.response

import com.example.mygallery.domain.images.Image
import com.example.mygallery.domain.images.ImageUrl
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageResponse(
    @field:Json(name = "id") val id: String? = null,
    @field:Json(name = "likes") val likesNumber: Int? = null,
    @field:Json(name = "urls") val imageUrl: ImageUrlObj? = null,
    @field:Json(name = "width") val width: Int? = null,
    @field:Json(name = "height") val height: Int? = null
)

@JsonClass(generateAdapter = true)
data class ImageUrlObj(
    @field:Json(name = "full") val full: String? = null,
    @field:Json(name = "regular") val regular: String? = null,
    @field:Json(name = "small") val small: String? = null
)

fun ImageResponse.toImage() = Image(
    id = id.orEmpty(),
    likesNumber = likesNumber ?: 0,
    imageUrl = imageUrl?.toImageUrl() ?: ImageUrl(),
    width = width ?: 0,
    height = height ?: 0
)

fun ImageUrlObj.toImageUrl() = ImageUrl(
    full = full.orEmpty(),
    regular = regular.orEmpty(),
    small = small.orEmpty()
)
