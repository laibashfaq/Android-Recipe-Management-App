//BackGroundImagesScreen3.kt
package com.example.saadat


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
@Composable
fun BackGroundImagesScreen3(navController: NavHostController) {
    Image(
        painter = painterResource(id = com.example.saadat.R.drawable.thirdscreen ),
        contentDescription = "Background Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
            .padding(9.dp)
    )
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "",
            modifier = Modifier.padding(bottom = 460.dp)
        )

        Text(
            text = stringResource(id = com.example.saadat.R.string.reinvent_your_lunch),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color(0xFFE65100), // Orange color
            modifier = Modifier.padding(bottom = 140.dp)
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { navController.navigate("sign_up_screen") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp)
                    .height(64.dp),
                shape = MaterialTheme.shapes.large,
                colors = ButtonDefaults.buttonColors(Color(0xFFE65100)) // Orange color
            ) {
                Text(stringResource(id = com.example.saadat.R.string.sign_up), fontSize = 30.sp)
            }
        }

        Button(
            onClick = {
                navController.navigate("sign_in_screen")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(Color(0xFFE65100)) // Orange color
        ) {
            Text(
                stringResource(id = com.example.saadat.R.string.sign_in),
                fontSize = 30.sp
            )
        }
    }
}