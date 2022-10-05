package com.example.mygallery.network

import com.example.mygallery.domain.images.Image
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class NetworkInteractor @Inject constructor(
    private val networkRepository: NetworkRepository
) {

    suspend fun getImages(): List<Image> = networkRepository.getImages()
}