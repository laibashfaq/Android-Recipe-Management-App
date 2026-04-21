//////RecipeDetailScreen.kt
////package com.example.saadat
////
////import androidx.compose.foundation.border
////import androidx.compose.foundation.layout.*
////import androidx.compose.material3.*
////import androidx.compose.runtime.*
////import androidx.compose.ui.Alignment
////import androidx.compose.ui.Modifier
////import androidx.compose.ui.graphics.Color
////import androidx.compose.ui.unit.dp
////import kotlinx.coroutines.Dispatchers
////import kotlinx.coroutines.withContext
////
////@Composable
////fun RecipeDetailScreen(recipeName: String, recipeRepository: RecipeRepository) {
////    var recipe by remember { mutableStateOf<Recipe?>(null) }
////
////    LaunchedEffect(recipeName) {
////        withContext(Dispatchers.IO) {
////            recipe = recipeRepository.getRecipeByName(recipeName)
////        }
////    }
////
////    Column(
////        modifier = Modifier
////            .fillMaxSize()
////            .padding(16.dp),
////        verticalArrangement = Arrangement.Center,
////        horizontalAlignment = Alignment.CenterHorizontally,
////    ) {
////        recipe?.let {
////            Box(
////                modifier = Modifier
////                    .fillMaxWidth()
////                    .padding(16.dp)
////                    .border(2.dp, Color(0xFFE65100)) // Orange border
////            ) {
////                Column(modifier = Modifier.padding(16.dp)) {
////                    Text(text = it.name, style = MaterialTheme.typography.headlineLarge)
////                    Spacer(modifier = Modifier.height(8.dp))
////                    Text(text = "Ingredients:", style = MaterialTheme.typography.headlineMedium)
////                    it.ingredients.split(", ").forEach { ingredient ->
////                        Text(text = ingredient, modifier = Modifier.padding(start = 8.dp))
////                    }
////                    Spacer(modifier = Modifier.height(8.dp))
////                    Text(text = "Instructions:", style = MaterialTheme.typography.headlineMedium)
////                    Text(text = it.instructions, modifier = Modifier.padding(start = 8.dp))
////                }
////            }
////        }
////    }
////}
//// RecipeDetailScreen.kt
package com.example.saadat

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RecipeDetailScreen(
    recipeName: String,
    recipeRepository: RecipeRepository,
    recipeViewModel: RecipeViewModel = viewModel(factory = RecipeViewModelFactory(recipeRepository))
) {
    // Fetch the recipe from the ViewModel
    LaunchedEffect(recipeName) {
        recipeViewModel.getRecipeByName(recipeName)
    }

    // Observe the recipe state
    val recipe by recipeViewModel.recipe.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        recipe?.let { recipe ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .border(2.dp, Color(0xFFE65100)) // Orange border
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = recipe.name, style = MaterialTheme.typography.headlineLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Ingredients:", style = MaterialTheme.typography.headlineMedium)
                    recipe.ingredients.split(",").forEach { ingredient ->
                        Text(text = ingredient.trim(), modifier = Modifier.padding(start = 8.dp))
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Instructions:", style = MaterialTheme.typography.headlineMedium)
                    Text(text = recipe.instructions, modifier = Modifier.padding(start = 8.dp))
                }
            }
        } ?: run {
            Text("Loading...", style = MaterialTheme.typography.headlineMedium)
        }
    }
}
