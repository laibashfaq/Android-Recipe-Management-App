////RecipeListScreen.kt
//package com.example.saadat
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.Button
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavHostController
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.withContext
//
//@Composable
//fun RecipeListScreen(navController: NavHostController, ingredients: List<String>, recipeRepository: RecipeRepository) {
//    var matchingRecipes by remember { mutableStateOf<List<Recipe>>(emptyList()) }
//
//    LaunchedEffect(ingredients) {
//        withContext(Dispatchers.IO) {
//            val allRecipes = ingredients.flatMap { ingredient ->
//                recipeRepository.getRecipesByIngredients(ingredient)
//            }.distinct()
//            matchingRecipes = allRecipes
//        }
//    }
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFFFFE0B2)) // Light orange background color
//    ) {
//        LazyColumn(modifier = Modifier.padding(16.dp)) {
//            items(matchingRecipes) { recipe ->
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(8.dp)
//                        .border(2.dp, Color(0xFFE65100)) // Orange border
//                        .clickable {
//                            navController.navigate("recipe_details/${recipe.name}")
//                        }
//                ) {
//                    Text(
//                        text = recipe.name,
//                        modifier = Modifier.padding(8.dp),
//                        style = MaterialTheme.typography.headlineMedium
//                    )
//                }
//                Spacer(modifier = Modifier.height(8.dp))
//            }
//        }
//    }
//}
package com.example.saadat

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun RecipeListScreen(navController: NavHostController, ingredients: List<String>, recipeRepository: RecipeRepository) {
    var matchingRecipes by remember { mutableStateOf<List<Recipe>>(emptyList()) }

    LaunchedEffect(ingredients) {
        withContext(Dispatchers.IO) {
            val allRecipes = ingredients.flatMap { ingredient ->
                recipeRepository.getRecipesByIngredients(ingredient)
            }.distinct()
            withContext(Dispatchers.Main) {
                matchingRecipes = allRecipes
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFE0B2)) // Light orange background color
    ) {
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(matchingRecipes) { recipe ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .border(2.dp, Color(0xFFE65100)) // Orange border
                        .clickable {
                            navController.navigate("recipe_details/${recipe.name}")
                        }
                ) {
                    Text(
                        text = recipe.name,
                        modifier = Modifier.padding(8.dp),
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

    }
}
