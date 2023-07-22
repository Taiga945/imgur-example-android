package com.example.imgur.galleryitem

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

@Composable
fun GalleryItemScreen(
    viewModel: GalleryViewModel = viewModel()
) {
    LaunchedEffect(
        key1 = Unit,
        block = {
            viewModel.initData()
        }
    )
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Text(text = viewModel.describe)
        AsyncImage(
            model = viewModel.url,
            contentDescription = null,
        )
        val commentState = viewModel.state.collectAsState()
        commentState.value?.data?.forEach {
            Text(text = it.comment)
        }
    }
}