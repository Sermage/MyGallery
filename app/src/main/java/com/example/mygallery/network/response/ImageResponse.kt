package com.example.mygallery.network.response

import com.example.mygallery.domain.images.Image
import com.example.mygallery.domain.images.ImageUrl
import com.squareup.moshi.Json

data class ImageResponse(
    @Json(name = "id") val id: String? = null,
    @Json(name = "likes") val likesNumber: Int? = null,
    @Json(name = "urls") val imageUrl: ImageUrlObj? = null,
)

data class ImageUrlObj(
    @Json(name = "full") val full: String? = null,
    @Json(name = "regular") val regular: String? = null,
    @Json(name = "small") val small: String? = null
)

fun ImageResponse.toImage() = Image(
    id = id.orEmpty(),
    likesNumber = likesNumber ?: 0,
    imageUrl = imageUrl?.toImageUrl() ?: ImageUrl()
)

fun ImageUrlObj.toImageUrl() = ImageUrl(
    full = full.orEmpty(),
    regular = regular.orEmpty(),
    small = small.orEmpty()
)
