package com.example.imgur.galleryitem

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val id: String = checkNotNull(savedStateHandle["imageId"])
    val url: String = checkNotNull(savedStateHandle["url"])
    val describe: String = checkNotNull(savedStateHandle["describe"])
}