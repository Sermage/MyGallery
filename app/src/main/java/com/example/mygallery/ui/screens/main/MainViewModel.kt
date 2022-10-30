package com.example.mygallery.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mygallery.base.EventHandler
import com.example.mygallery.domain.images.Image
import com.example.mygallery.network.NetworkInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

sealed class MainScreenState {
    object Loading : MainScreenState()
    data class Content(val images: List<Image>) : MainScreenState()
    data class Error(val message: String) : MainScreenState()
}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val networkInteractor: NetworkInteractor
) : ViewModel(), EventHandler<MainScreenEvent> {

    private val imagesMutableState = MutableStateFlow<MainScreenState>(MainScreenState.Loading)
    val imagesState = imagesMutableState.asStateFlow()

    init {
        getData()
    }

    override fun obtainEvent(event: MainScreenEvent) {
        when (val currentState = imagesState.value) {
            is MainScreenState.Error -> reduce(currentState, event)
        }
    }

    private fun reduce(currentState: MainScreenState.Error, event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.Reload -> getData()

        }
    }

    private fun getData() {
        flow {
            emit(networkInteractor.getImages())
        }
            .onStart { loading() }
            .onEach { updateContent(it) }
            .catch { handleError(it) }
            .launchIn(viewModelScope)
    }

    private suspend fun handleError(error: Throwable) {
        imagesMutableState.emit(MainScreenState.Error(error.message ?: "Something went wrong"))
    }

    private suspend fun updateContent(content: List<Image>) {
        imagesMutableState.emit(MainScreenState.Content(images = content))
    }

    private suspend fun loading() {
        imagesMutableState.emit(MainScreenState.Loading)
    }
}