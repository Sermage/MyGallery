package com.sermage.mygallery.domain.images

import com.sermage.mygallery.utils.Constants.EMPTY_STRING

data class Image(
    val id: String = EMPTY_STRING,
    val likesNumber: Int = 0,
    val width: Int = 0,
    val height: Int = 0,
    val imageUrl: ImageUrl = ImageUrl()
)

data class ImageUrl(
    val full: String = EMPTY_STRING,
    val regular: String = EMPTY_STRING,
    val small: String = EMPTY_STRING
)
