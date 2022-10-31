package com.example.mygallery.ui.elements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mygallery.R
import com.example.mygallery.ui.theme.MyGalleryTheme
import com.example.mygallery.utils.Constants.EMPTY_STRING

@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    readOnly: Boolean = false,
    value: String = EMPTY_STRING,
    onValueChange: (String) -> Unit = {},
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        enabled = isEnabled,
        readOnly = readOnly,
        modifier = modifier
            .fillMaxWidth()
            .heightIn(40.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = MaterialTheme.colors.onSurface.copy(alpha = 0.8f)
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        placeholder = {
            Text(
                text = stringResource(R.string.search_hint),
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.32f)
            )
        },
        shape = MaterialTheme.shapes.small
    )
}

@Preview(showBackground = true)
@Composable
fun SearchFieldPreview() {
    MyGalleryTheme {
        SearchField()
    }
}

@Preview(showBackground = true)
@Composable
fun SearchFieldDarkPreview() {
    MyGalleryTheme(darkTheme = true) {
        SearchField()
    }
}