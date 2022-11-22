package com.sermage.mygallery.network

import com.sermage.mygallery.network.response.ImageResponse
import com.sermage.mygallery.network.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/photos")
    suspend fun getPhotos(): List<ImageResponse>

    @GET("/search/photos")
    suspend fun getSearchablePhotos(
        @Query(QUERY_PARAM) query: String,
        @Query(PAGE_PARAM) page: Int = 1
    ): SearchResponse

    companion object {
        private const val QUERY_PARAM = "query"
        private const val PAGE_PARAM = "page"
    }
}