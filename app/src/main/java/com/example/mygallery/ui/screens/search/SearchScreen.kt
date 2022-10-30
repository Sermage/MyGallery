package com.example.mygallery.ui.screens.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mygallery.R
import com.example.mygallery.ui.elements.SearchField
import com.example.mygallery.ui.theme.MyGalleryTheme

@Composable
fun SearchScreen() {
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
            Modifier.padding(horizontal = 24.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    MyGalleryTheme {
        SearchScreen()
    }
}