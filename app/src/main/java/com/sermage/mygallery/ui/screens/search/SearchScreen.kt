package com.sermage.mygallery.ui.screens.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import com.sermage.mygallery.R
import com.sermage.mygallery.ui.elements.CircularIndeterminateProgressBar
import com.sermage.mygallery.ui.elements.ImagesListGrid
import com.sermage.mygallery.ui.elements.SearchField
import com.sermage.mygallery.ui.theme.MyGalleryTheme
import com.sermage.mygallery.utils.Constants
import com.sermage.mygallery.utils.debounce

private const val SEARCH_DEBOUNCE_TIME_MILLIS = 500L

@Composable
fun SearchScreen(
    googleAssistantQuery: String? = null
) {
    val vm = hiltViewModel<SearchViewModel>()
    val state = vm.searchScreenState.collectAsState().value
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_surf_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .padding(top = 8.dp, bottom = 24.dp, start = 24.dp)
                .width(58.dp)
                .height(40.dp),
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface)
        )
        SearchFieldImpl(vm, googleAssistantQuery)

        Spacer(modifier = Modifier.height(32.dp))

        when (state) {
            is SearchScreenState.Loading -> CircularIndeterminateProgressBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 56.dp)
            )
            is SearchScreenState.Content -> ImagesListGrid(
                items = state.images,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        }
    }
}

@Composable
private fun SearchFieldImpl(
    vm: SearchViewModel,
    googleAssistantQuery: String?
) {
    val initialQuery = googleAssistantQuery ?: Constants.EMPTY_STRING
    var query by remember {
        mutableStateOf(
            TextFieldValue(
                text = initialQuery,
                selection = TextRange(initialQuery.length)
            )
        )
    }
    val focusRequester = remember { FocusRequester() }

    SearchField(
        Modifier
            .padding(horizontal = 24.dp)
            .focusRequester(focusRequester),
        value = query
    ) { text ->
        query = text
        debounce(SEARCH_DEBOUNCE_TIME_MILLIS, vm.viewModelScope) {
            vm.obtainEvent(
                SearchScreenEvent.SearchValueChanged(query.text)
            )
        }
    }
    LaunchedEffect(key1 = Unit) {
        focusRequester.requestFocus()
        if (initialQuery.isNotEmpty()) {
            vm.obtainEvent(
                SearchScreenEvent.SearchValueChanged(initialQuery)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    MyGalleryTheme {
        SearchScreen()
    }
}