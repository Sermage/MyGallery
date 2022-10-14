package com.example.mygallery.ui.screens.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mygallery.domain.images.Image
import com.example.mygallery.network.NetworkInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val networkInteractor: NetworkInteractor
) : ViewModel() {

    private val imagesMutableState = MutableStateFlow<List<Image>>(emptyList())
    val imagesState = imagesMutableState.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        flow {
            emit(networkInteractor.getImages())
        }
            .onEach { imagesMutableState.emit(it) }
            .catch { onError(it) }
            .launchIn(viewModelScope)
    }

    private fun onError(error: Throwable) {
        Log.d("ERROR", error.message.toString())
    }
}