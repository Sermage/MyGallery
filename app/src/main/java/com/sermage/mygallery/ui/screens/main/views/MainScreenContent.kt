package com.sermage.mygallery.ui.screens.main.views

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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sermage.mygallery.R
import com.sermage.mygallery.domain.images.Image
import com.sermage.mygallery.navigation.SEARCH_SCREEN_ROUTE
import com.sermage.mygallery.ui.elements.CircularIndeterminateProgressBar
import com.sermage.mygallery.ui.elements.ImagesListGrid
import com.sermage.mygallery.ui.elements.SearchButton
import com.sermage.mygallery.ui.theme.MyGalleryTheme

@Composable
fun MainScreenContent(
    content: List<Image>,
    isLoading: Boolean = false,
    navController: NavController
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
        SearchButton {
            navController.navigate(SEARCH_SCREEN_ROUTE)
        }
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
            isLoading = true,
            navController = rememberNavController()
        )
    }
}