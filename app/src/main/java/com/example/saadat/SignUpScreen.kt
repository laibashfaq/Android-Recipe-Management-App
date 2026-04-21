//SignUpScreen.kt
package com.example.saadat

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch

@Composable
fun SignUpScreen(navController: NavHostController, userRepository: UserRepository) {
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val confirmPasswordState = remember { mutableStateOf("") }
    val errorMessage = remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = com.example.saadat.R.drawable.signinlogo),
            contentDescription = "Sign Up Image",
            modifier = Modifier.size(350.dp)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 240.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Create Account",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFE65100)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Sign up to get started",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFE65100),
            modifier = Modifier.padding(15.dp)
        )

        OutlinedTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = { Text(text = "Email Address") },
            textStyle = TextStyle(fontSize = 20.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        OutlinedTextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            textStyle = TextStyle(fontSize = 20.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )

        OutlinedTextField(
            value = confirmPasswordState.value,
            onValueChange = { confirmPasswordState.value = it },
            label = { Text(text = "Confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            textStyle = TextStyle(fontSize = 20.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                coroutineScope.launch {
                    if (passwordState.value == confirmPasswordState.value) {
                        userRepository.insertUser(User(emailState.value, passwordState.value))
                        navController.navigate("login_successful_screen")
                    } else {
                        errorMessage.value = "Passwords do not match"
                    }
                }
            },
            modifier = Modifier
                .height(80.dp)
                .padding(top = 20.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = MaterialTheme.shapes.large,
            colors = ButtonDefaults.buttonColors(Color(0xFFE65100)) // Orange color
        ) {
            Text(text = "Sign Up", fontSize = 20.sp)
        }

        if (errorMessage.value.isNotEmpty()) {
            Text(text = errorMessage.value, color = Color.Red, modifier = Modifier.padding(top = 8.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Already have an account? Sign In",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFE65100),
            modifier = Modifier
                .padding(15.dp)
                .clickable {
                    navController.navigate("sign_in_screen")
                }
        )
    }
}
