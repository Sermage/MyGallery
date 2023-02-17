package com.sermage.mygallery.ui.screens.main

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.sermage.mygallery.ui.screens.main.views.MainScreenContent
import com.sermage.mygallery.ui.screens.main.views.MainScreenError

@Composable
fun MainScreen(
    onSearchButtonClick: () -> Unit,
    backClick: () -> Unit = {}
) {
    BackHandler() {
        backClick()
    }

    val vm = hiltViewModel<MainViewModel>()
    val state = vm.mainScreenState.collectAsState().value
    when (state) {
        is MainScreenState.Loading -> MainScreenContent(
            content = emptyList(),
            isLoading = true,
            onSearchButtonClick = onSearchButtonClick
        )
        is MainScreenState.Content -> MainScreenContent(
            content = state.images,
            isLoading = false,
            onSearchButtonClick = onSearchButtonClick
        )
        is MainScreenState.Error -> MainScreenError { vm.obtainEvent(MainScreenEvent.Reload) }
    }
}
