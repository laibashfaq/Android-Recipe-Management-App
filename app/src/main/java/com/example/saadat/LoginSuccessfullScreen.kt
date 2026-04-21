//LoginSuccessfulScreen.kt
package com.example.saadat
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun LoginSuccessfulScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFE0B2)) // Light orange background color
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.signinlogo),
                contentDescription = "Sign In Image",
                modifier = Modifier
                    .size(350.dp)
                    .padding(bottom = 0.dp)
            )

            Text(
                text = "Login Successful",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color(0xFFE65100),
                modifier = Modifier.padding(top = 20.dp)
            )

            Text(
                text = "Sort Out Your",
                fontWeight = FontWeight.Bold,
                fontSize = 50.sp,
                color = Color(0xFFE65100),
                modifier = Modifier.padding(top = 20.dp)
            )
            Text(
                text = " Meal with Meal",
                fontWeight = FontWeight.Bold,
                fontSize = 50.sp,
                color = Color(0xFFE65100)
            )
            Text(
                text = "Magic",
                fontWeight = FontWeight.Bold,
                fontSize = 50.sp,
                color = Color(0xFFE65100)
            )
            Button(
                onClick = {  navController.navigate("meal_magic_screen")  },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFE65100)) // Orange color
            ) {
                Text(text = "Go to Meal Magic", fontSize = 30.sp)
            }
        }
    }
}
