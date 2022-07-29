package com.example.mygallery.network

import com.example.mygallery.domain.images.Image
import com.example.mygallery.network.response.toImage
import javax.inject.Inject

class NetworkRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getImages(): List<Image> = apiService.getPhotos()
        .map { it.toImage() }
}