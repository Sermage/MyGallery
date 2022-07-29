package com.example.mygallery.domain.images

import com.example.mygallery.utils.Constants.EMPTY_STRING

data class Image(
    val id: String,
    val likesNumber: Int,
    val imageUrl: ImageUrl
)

data class ImageUrl(
    val full: String = EMPTY_STRING,
    val regular: String = EMPTY_STRING,
    val small: String = EMPTY_STRING
)
