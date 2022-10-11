package com.example.mygallery.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mygallery.MainViewModel
import com.example.mygallery.R
import com.example.mygallery.ui.elements.ImagesListGrid
import com.example.mygallery.ui.elements.SearchField

@Composable
fun MainScreen() {
    val vm = hiltViewModel<MainViewModel>()
    val images = vm.imagesState.collectAsState().value
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
        SearchField(Modifier.padding(horizontal = 24.dp))
        Spacer(modifier = Modifier.height(32.dp))
        ImagesListGrid(
            items = images,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
    }
}
