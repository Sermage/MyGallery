package com.sermage.mygallery.ui.screens.search

import android.app.Application
import android.content.Intent
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.sermage.mygallery.MainActivity
import com.sermage.mygallery.base.EventHandler
import com.sermage.mygallery.domain.images.Image
import com.sermage.mygallery.network.NetworkInteractor
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
    private val networkInteractor: NetworkInteractor,
    application: Application
) : AndroidViewModel(application), EventHandler<SearchScreenEvent> {

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
            .onEach {
                getSearchableItems(it)
                pushDynamicShortcuts(query)
            }
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

    private fun pushDynamicShortcuts(query: String) {
        val intent = Intent(getApplication(), MainActivity::class.java)
        intent.action = Intent.ACTION_VIEW
        val shortcutInfo = ShortcutInfoCompat.Builder(getApplication(), "shortcut")
            .setShortLabel(query)
            .setLongLabel("find $query")
            .addCapabilityBinding("actions.intent.GET_THING", "thing.name", listOf(query))
            .setIntent(intent)
            .build()

        ShortcutManagerCompat.pushDynamicShortcut(getApplication(), shortcutInfo)
    }

    private companion object {
        private const val MIN_SEARCH_QUERY_LENGTH = 3
    }

}