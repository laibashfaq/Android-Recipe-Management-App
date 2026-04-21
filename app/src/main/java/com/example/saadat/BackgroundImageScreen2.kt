//BackGroundImagesScreen2.kt
package com.example.saadat

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun BackGroundImagesScreen2(navController: NavHostController) {
    LaunchedEffect(Unit) {
        delay(2000L) // Delay for 2 seconds
        navController.navigate("background_image_3")
    }
    Image(
        painter = painterResource(id = R.drawable.openload),
        contentDescription = "Background Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}

