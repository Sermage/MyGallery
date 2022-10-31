package com.example.mygallery.ui.screens.search

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import com.example.mygallery.R
import com.example.mygallery.ui.elements.CircularIndeterminateProgressBar
import com.example.mygallery.ui.elements.ImagesListGrid
import com.example.mygallery.ui.elements.SearchField
import com.example.mygallery.ui.theme.MyGalleryTheme
import com.example.mygallery.utils.debounce

private const val SEARCH_DEBOUNCE_TIME_MILLIS = 500L

@Composable
fun SearchScreen() {
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
        SearchFieldImpl(vm)

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
    vm: SearchViewModel
) {
    var query by remember { mutableStateOf("") }
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
                SearchScreenEvent.SearchValueChanged(query)
            )
        }
    }
    LaunchedEffect(key1 = Unit) {
        focusRequester.requestFocus()
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    MyGalleryTheme {
        SearchScreen()
    }
}