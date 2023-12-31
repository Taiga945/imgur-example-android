package com.example.imgur.gallery

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.imgur.HomeViewModel
import com.example.imgur.ui.theme.ImgurTheme
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun GalleryScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = viewModel()
) {
    LaunchedEffect(
        key1 = Unit,
        block = {
            viewModel.initData()
        }
    )
    val imagesState = viewModel.state.collectAsState()
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        val openDialog = remember { mutableStateOf(false) }
        val textState = remember {
            mutableStateOf("Android")
        }
        val firstImage = imagesState.value?.images?.firstOrNull()
        Greeting(textState.value)
        Button(
            onClick = {
                firstImage?.let {
                    navController.navigate(
                        "galleryItem/" + it.id + "/" + URLEncoder.encode(
                            it.imageLink,
                            StandardCharsets.UTF_8.toString()
                        ) + "/" + it.describe
                    )

                }
            },
            modifier = Modifier.wrapContentSize(),
        ) {
            Text("change")
        }
        imagesState.value?.images?.forEach { image ->
            Column(modifier = Modifier.clickable {
                navController.navigate(
                    "galleryItem/" + image.id + "/" + URLEncoder.encode(
                        image.imageLink,
                        StandardCharsets.UTF_8.toString()
                    ) + "/" + image.title
                )
            }) {
                Text(text = image.title)
                AsyncImage(
                    model = image.imageLink,
                    contentDescription = null,
                )
            }
        }
        Dialog(openDialog = openDialog)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    if (name == "Ola") {
        Text(text = "Maciek")
    } else {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }
}

@Composable
fun Dialog(openDialog: MutableState<Boolean>) {
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onDismissRequest.
                openDialog.value = false
            },
            confirmButton = {
                Surface(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight(),
                    shape = MaterialTheme.shapes.large,
                    tonalElevation = AlertDialogDefaults.TonalElevation
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "This area typically contains the supportive text " +
                                    "which presents the details regarding the Dialog's purpose.",
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        TextButton(
                            onClick = {
                                openDialog.value = false
                            },
                            modifier = Modifier.align(Alignment.End)
                        ) {
                            Text("Confirm")
                        }
                    }
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    ImgurTheme {
        GalleryScreen(navController = rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun DialogPreview() {
    ImgurTheme {
        Dialog(remember {
            mutableStateOf(true)
        })
    }
}