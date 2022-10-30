package com.example.mygallery.ui.screens.main.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mygallery.R
import com.example.mygallery.domain.images.Image
import com.example.mygallery.ui.elements.CircularIndeterminateProgressBar
import com.example.mygallery.ui.elements.ImagesListGrid
import com.example.mygallery.ui.elements.SearchField
import com.example.mygallery.ui.theme.MyGalleryTheme

@Composable
fun MainScreenContent(
    content: List<Image>,
    isLoading: Boolean = false
) {
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
        SearchField(
            Modifier.padding(horizontal = 24.dp),
            isEnabled = !isLoading
        )
        Spacer(modifier = Modifier.height(32.dp))

        val loading by remember {
            mutableStateOf(isLoading)
        }
        if (loading) {
            CircularIndeterminateProgressBar(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 56.dp)
            )
        } else {
            ImagesListGrid(
                items = content,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenContentPreview() {
    MyGalleryTheme {
        MainScreenContent(
            content = emptyList(),
            isLoading = true
        )
    }
}