package com.sermage.mygallery.network

import com.sermage.mygallery.domain.images.Image
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class NetworkInteractor @Inject constructor(
    private val networkRepository: NetworkRepository
) {

    suspend fun getImages(): List<Image> = networkRepository.getImages()

    suspend fun getSearchableImages(query: String, page: Int = 1): List<Image> =
        networkRepository.getSearchableImages(query, page)
}