package com.example.mygallery.ui.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mygallery.ui.screens.main.views.MainScreenContent
import com.example.mygallery.ui.screens.main.views.MainScreenError

@Composable
fun MainScreen() {
    val vm = hiltViewModel<MainViewModel>()
    val state = vm.imagesState.collectAsState().value
    when (state) {
        is MainScreenState.Loading -> MainScreenContent(content = emptyList(), isLoading = true)
        is MainScreenState.Content -> MainScreenContent(content = state.images, isLoading = false)
        is MainScreenState.Error -> MainScreenError { vm.obtainEvent(MainScreenEvent.Reload) }
    }
}



