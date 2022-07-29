package com.example.mygallery.network

import com.example.mygallery.network.response.ImageResponse
import retrofit2.http.GET

interface ApiService {

    @GET("/photos")
    suspend fun getPhotos(): List<ImageResponse>
}