package com.example.mygallery.ui.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mygallery.base.EventHandler
import com.example.mygallery.domain.images.Image
import com.example.mygallery.network.NetworkInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

sealed class SearchScreenState {
    object Loading : SearchScreenState()
    object EmptyResult : SearchScreenState()
    data class Content(val images: List<Image>) : SearchScreenState()
    data class Error(val message: String) : SearchScreenState()
}

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val networkInteractor: NetworkInteractor
) : ViewModel(), EventHandler<SearchScreenEvent> {

    private val searchScreenMutableState =
        MutableStateFlow<SearchScreenState>(SearchScreenState.EmptyResult)
    val searchScreenState = searchScreenMutableState.asStateFlow()

    override fun obtainEvent(event: SearchScreenEvent) {
        when (event) {
            is SearchScreenEvent.SearchValueChanged -> reduce(event)
        }
    }

    private fun reduce(event: SearchScreenEvent.SearchValueChanged) {
        if (event.value.length >= MIN_SEARCH_QUERY_LENGTH) {
            searchImages(event.value)
        }
    }

    private fun searchImages(query: String) =
        flow {
            emit(networkInteractor.getSearchableImages(query))
        }
            .onStart { loading() }
            .onEach { getSearchableItems(it) }
            .catch { handleError(it) }
            .launchIn(viewModelScope)

    private suspend fun loading() = searchScreenMutableState.emit(SearchScreenState.Loading)

    private suspend fun getSearchableItems(images: List<Image>) =
        searchScreenMutableState.emit(
            SearchScreenState.Content(images).takeIf { images.isNotEmpty() }
                ?: SearchScreenState.EmptyResult)

    private suspend fun handleError(error: Throwable) = searchScreenMutableState.emit(
        SearchScreenState.Error(
            error.message ?: "Something went wrong"
        )
    )

    private companion object {
        private const val MIN_SEARCH_QUERY_LENGTH = 3
    }

}