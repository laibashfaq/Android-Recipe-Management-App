////MealMagicScreen.kt
//package com.example.saadat
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import androidx.compose.ui.text.TextStyle
//
//@Composable
//fun MealMagicScreen(navController: NavHostController, userName: String) {
//    var veg1 by remember { mutableStateOf(TextFieldValue("Noodles")) }
//    var veg2 by remember { mutableStateOf(TextFieldValue("Tomato")) }
//    var additionalIngredients by remember { mutableStateOf(TextFieldValue("")) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(20.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text(
//            text = "Hello, $userName",
//            fontSize = 24.sp,
//            color = Color(0xFFE65100), // Orange color
//            modifier = Modifier.padding(bottom = 8.dp)
//        )
//
//        Text(
//            text = "Enter the ingredients for your meal",
//            fontSize = 16.sp,
//            color = Color.Black,
//            modifier = Modifier.padding(bottom = 16.dp)
//        )
//
//        TextField(
//            value = veg1,
//            onValueChange = { veg1 = it },
//            label = { Text("Vegetable 1") },
//            textStyle = TextStyle(fontSize = 20.sp),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 16.dp)
//        )
//
//        TextField(
//            value = veg2,
//            onValueChange = { veg2 = it },
//            label = { Text("Vegetable 2") },
//            textStyle = TextStyle(fontSize = 20.sp),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 16.dp)
//        )
//
//        TextField(
//            value = additionalIngredients,
//            onValueChange = { additionalIngredients = it },
//            label = { Text("Additional Ingredients") },
//            textStyle = TextStyle(fontSize = 20.sp),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 16.dp)
//        )
//
//        Button(
//            onClick = {
//                val ingredients = listOf(veg1.text, veg2.text) + additionalIngredients.text.split(", ")
//                navController.navigate("recipe_list?ingredients=${ingredients.joinToString(",")}")
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(70.dp),
//            shape = MaterialTheme.shapes.large,
//            colors = ButtonDefaults.buttonColors(Color(0xFFE65100)) // Orange color
//        ) {
//            Text("Submit", fontSize = 20.sp)
//        }
//    }
//}
////MealMagicScreen.kt
//package com.example.saadat
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import androidx.compose.ui.text.TextStyle
//
//@Composable
//fun MealMagicScreen(navController: NavHostController, userName: String, recipeViewModel: RecipeViewModel) {
//    var veg1 by remember { mutableStateOf(TextFieldValue("Noodles")) }
//    var veg2 by remember { mutableStateOf(TextFieldValue("Tomato")) }
//    var additionalIngredients by remember { mutableStateOf(TextFieldValue("")) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(20.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text(
//            text = "Hello, $userName",
//            fontSize = 24.sp,
//            color = Color(0xFFE65100), // Orange color
//            modifier = Modifier.padding(bottom = 8.dp)
//        )
//
//        Text(
//            text = "Enter the ingredients for your meal",
//            fontSize = 16.sp,
//            color = Color.Black,
//            modifier = Modifier.padding(bottom = 16.dp)
//        )
//
//        TextField(
//            value = veg1,
//            onValueChange = { veg1 = it },
//            label = { Text("Vegetable 1") },
//            textStyle = TextStyle(fontSize = 20.sp),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 16.dp)
//        )
//
//        TextField(
//            value = veg2,
//            onValueChange = { veg2 = it },
//            label = { Text("Vegetable 2") },
//            textStyle = TextStyle(fontSize = 20.sp),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 16.dp)
//        )
//
//        TextField(
//            value = additionalIngredients,
//            onValueChange = { additionalIngredients = it },
//            label = { Text("Additional Ingredients") },
//            textStyle = TextStyle(fontSize = 20.sp),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 16.dp)
//        )
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Button(
//                onClick = {
//                    val ingredients = listOf(veg1.text, veg2.text) + additionalIngredients.text.split(", ")
//                    navController.navigate("recipe_list?ingredients=${ingredients.joinToString(",")}")
//                },
//                modifier = Modifier
//                    .weight(1f)
//                    .height(70.dp)
//                    .padding(end = 8.dp),
//                shape = MaterialTheme.shapes.large,
//                colors = ButtonDefaults.buttonColors(Color(0xFFE65100)) // Orange color
//            ) {
//                Text("Submit", fontSize = 20.sp)
//            }
//
//            Button(
//                onClick = {
//                    val ingredients = listOf(veg1.text, veg2.text) + additionalIngredients.text.split(", ")
//                    recipeViewModel.deleteRecipesByIngredients(ingredients)
//                },
//                modifier = Modifier
//                    .weight(1f)
//                    .height(70.dp)
//                    .padding(start = 8.dp),
//                shape = MaterialTheme.shapes.large,
//                colors = ButtonDefaults.buttonColors(Color(0xFFE65100)) // Orange color
//            ) {
//                Text("Delete", fontSize = 20.sp)
//            }
//        }
//    }
//}
package com.example.saadat

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.text.TextStyle
import kotlinx.coroutines.launch

@Composable
fun MealMagicScreen(navController: NavHostController, userName: String, recipeViewModel: RecipeViewModel) {
    var veg1 by remember { mutableStateOf(TextFieldValue("Noodles")) }
    var veg2 by remember { mutableStateOf(TextFieldValue("Tomato")) }
    var additionalIngredients by remember { mutableStateOf(TextFieldValue("")) }
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hello, $userName",
                fontSize = 24.sp,
                color = Color(0xFFE65100), // Orange color
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "Enter the ingredients for your meal",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            TextField(
                value = veg1,
                onValueChange = { veg1 = it },
                label = { Text("Vegetable 1") },
                textStyle = TextStyle(fontSize = 20.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            TextField(
                value = veg2,
                onValueChange = { veg2 = it },
                label = { Text("Vegetable 2") },
                textStyle = TextStyle(fontSize = 20.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            TextField(
                value = additionalIngredients,
                onValueChange = { additionalIngredients = it },
                label = { Text("Additional Ingredients") },
                textStyle = TextStyle(fontSize = 20.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        val ingredients = listOf(veg1.text, veg2.text) + additionalIngredients.text.split(", ")
                        navController.navigate("recipe_list?ingredients=${ingredients.joinToString(",")}")
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(70.dp)
                        .padding(end = 8.dp),
                    shape = MaterialTheme.shapes.large,
                    colors = ButtonDefaults.buttonColors(Color(0xFFE65100)) // Orange color
                ) {
                    Text("Submit", fontSize = 20.sp)
                }

                Button(
                    onClick = {
                        val ingredients = listOf(veg1.text, veg2.text) + additionalIngredients.text.split(", ")
                        coroutineScope.launch {
                            recipeViewModel.deleteRecipesByIngredients(ingredients)
                            snackbarHostState.showSnackbar("Recipe deleted successfully")
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(70.dp)
                        .padding(start = 8.dp),
                    shape = MaterialTheme.shapes.large,
                    colors = ButtonDefaults.buttonColors(Color(0xFFE65100)) // Orange color
                ) {
                    Text("Delete", fontSize = 20.sp)
                }
            }
        }

        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        )
    }
}
