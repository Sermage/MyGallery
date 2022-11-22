package com.sermage.mygallery.network

import com.sermage.mygallery.domain.images.Image
import com.sermage.mygallery.network.response.toImage
import javax.inject.Inject

class NetworkRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getImages(): List<Image> = apiService.getPhotos()
        .map { it.toImage() }

    suspend fun getSearchableImages(query: String, page: Int): List<Image> =
        apiService.getSearchablePhotos(query, page).results?.map { it.toImage() } ?: emptyList()
}