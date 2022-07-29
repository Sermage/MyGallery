package com.example.mygallery.network

import com.example.mygallery.domain.images.Image
import javax.inject.Inject

class NetworkInteractor @Inject constructor(
    private val networkRepository: NetworkRepository
) {

    suspend fun getImages(): List<Image> = networkRepository.getImages()
}