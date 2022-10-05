package com.example.mygallery

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mygallery.domain.images.Image
import com.example.mygallery.network.NetworkInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var networkInteractor: NetworkInteractor

    private var getImagesJob: Job? = null
    private val imagesMutableState = MutableStateFlow<List<Image>>(emptyList())
    val imagesState = imagesMutableState.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        if (getImagesJob != null) return

        getImagesJob = viewModelScope.launch {
            //start loading
            try {

                val images = networkInteractor.getImages()
                imagesMutableState.emit(images)
            } catch (e: Exception) {
                onError(e)
            }

            //end loading

        }
    }

    private fun onError(error: Throwable) {
        Log.d("ERROR", error.message.toString())
    }
}