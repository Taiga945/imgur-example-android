package com.example.imgur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.imgur.gallery.GalleryScreen
import com.example.imgur.galleryitem.GalleryItemScreen
import com.example.imgur.ui.theme.ImgurTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()



            ImgurTheme {
                // A surface container using the 'background' color from the theme
                NavHost(navController = navController, startDestination = "home", builder = {
                    composable("home") { GalleryScreen(navController) }
                    composable(
                        "galleryItem/{imageId}/{url}/{describe}",
                        arguments = listOf(
                            navArgument(
                                "imageId",
                                builder = { type = NavType.StringType }
                            ),
                            navArgument(
                                "url",
                                builder = { type = NavType.StringType }
                            ),
                            navArgument(
                                "describe",
                                builder = { type = NavType.StringType }
                            )
                        )
                    ) { GalleryItemScreen() }
                })
            }
        }
    }
}

