package com.example.mygallery.ui.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mygallery.ui.screens.main.views.MainScreenContent
import com.example.mygallery.ui.screens.main.views.MainScreenError

@Composable
fun MainScreen(
    navController: NavController
) {
    val vm = hiltViewModel<MainViewModel>()
    val state = vm.mainScreenState.collectAsState().value
    when (state) {
        is MainScreenState.Loading -> MainScreenContent(
            content = emptyList(),
            isLoading = true,
            navController
        )
        is MainScreenState.Content -> MainScreenContent(
            content = state.images,
            isLoading = false,
            navController
        )
        is MainScreenState.Error -> MainScreenError { vm.obtainEvent(MainScreenEvent.Reload) }
    }
}
