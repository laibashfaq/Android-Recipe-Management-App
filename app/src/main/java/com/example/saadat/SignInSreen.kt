//SignInScreen.kt
package com.example.saadat

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignInScreen(navController: NavHostController, userRepository: UserRepository) {
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val errorMessage = remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = com.example.saadat.R.drawable.signinlogo),
            contentDescription = "Sign In Image",
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
            text = "Welcome Back",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFE65100)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Sign in to continue",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFE65100),
            modifier = Modifier.padding(15.dp)
        )

        OutlinedTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = { Text(text = "Email Address") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(androidx.compose.ui.focus.FocusDirection.Down)
                }
            )
        )

        OutlinedTextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    coroutineScope.launch {
                        val user = userRepository.getUser(emailState.value, passwordState.value)
                        if (user != null) {
                            navController.navigate("login_successful_screen")
                        } else {
                            errorMessage.value = "Invalid credentials"
                        }
                    }
                }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Forgot Password?",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFE65100),
            modifier = Modifier
                .padding(15.dp)
                .clickable {
                    navController.navigate("sign_up_screen")
                }
        )

        Button(
            onClick = {
                coroutineScope.launch {
                    val user = userRepository.getUser(emailState.value, passwordState.value)
                    if (user != null) {
                        navController.navigate("login_successful_screen")
                    } else {
                        errorMessage.value = "Invalid credentials"
                    }
                }
            },
            modifier = Modifier
                .height(80.dp)
                .padding(top = 20.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = MaterialTheme.shapes.large,
            colors = ButtonDefaults.buttonColors(Color(0xFFE65100))
        ) {
            Text(text = "Sign In")
        }

        if (errorMessage.value.isNotEmpty()) {
            Text(text = errorMessage.value, color = Color.Red, modifier = Modifier.padding(top = 8.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Don't have an account? Sign Up",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFE65100),
            modifier = Modifier
                .padding(15.dp)
                .clickable {
                    navController.navigate("sign_up_screen")
                }
        )
    }
}
