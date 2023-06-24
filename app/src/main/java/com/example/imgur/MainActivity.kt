package com.example.imgur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.imgur.ui.theme.ImgurTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImgurTheme {
                // A surface container using the 'background' color from the theme
                Screen()
            }
        }
    }
}
@Composable
fun Screen(
    viewModel: HomeViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        val openDialog = remember { mutableStateOf(false) }
        val textState = remember {
            mutableStateOf("Android")
        }
        Greeting(textState.value)
        Button(
            onClick = {
                if (textState.value != "Ola") {
                    textState.value = "Ola"
                } else {
                    textState.value = "Android"
                }
                openDialog.value = true
            },
            modifier = Modifier.wrapContentSize(),
        ) {
            Text("change")
        }
        AsyncImage(
            model = "https://i.imgur.com/hkiVfFG.jpg",
            contentDescription = null,
        )
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
        Screen()
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