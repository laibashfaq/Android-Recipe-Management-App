//// AppNavigator.kt
//package com.example.saadat
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//
//@Composable
//fun AppNavigator(userRepository: UserRepository, recipeRepository: RecipeRepository) {
//    val navController = rememberNavController()
//
//    NavHost(navController = navController, startDestination = "background_image_1") {
//        composable("background_image_1") { BackGroundImageScreen1(navController) }
//        composable("background_image_2") { BackGroundImagesScreen2(navController) }
//        composable("background_image_3") { BackGroundImagesScreen3(navController) }
//        composable("sign_in_screen") { SignInScreen(navController = navController, userRepository = userRepository) }
//        composable("sign_up_screen") { SignUpScreen(navController = navController, userRepository = userRepository) }
//        composable("login_successful_screen") { LoginSuccessfulScreen(navController = navController) }
//        composable("meal_magic_screen") { backStackEntry ->
//            val userName = backStackEntry.arguments?.getString("userName") ?: "User"
//            MealMagicScreen(navController = navController, userName = userName)
//        }
//        composable("recipe_list?ingredients={ingredients}") { backStackEntry ->
//            val ingredients = backStackEntry.arguments?.getString("ingredients")?.split(",") ?: emptyList()
//            RecipeListScreen(navController = navController, ingredients = ingredients, recipeRepository = recipeRepository)
//        }
//        composable("recipe_details/{recipeName}") { backStackEntry ->
//            val recipeName = backStackEntry.arguments?.getString("recipeName") ?: ""
//            RecipeDetailScreen(recipeName = recipeName, recipeRepository = recipeRepository)
//        }
//    }
//}
//package com.example.saadat
//
//import androidx.compose.runtime.Composable
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//
//@Composable
//fun AppNavigator(userRepository: UserRepository, recipeRepository: RecipeRepository) {
//    val navController = rememberNavController()
//
//    NavHost(navController = navController, startDestination = "background_image_1") {
//        composable("background_image_1") { BackGroundImageScreen1(navController) }
//        composable("background_image_2") { BackGroundImagesScreen2(navController) }
//        composable("background_image_3") { BackGroundImagesScreen3(navController) }
//        composable("sign_in_screen") { SignInScreen(navController = navController, userRepository = userRepository) }
//        composable("sign_up_screen") { SignUpScreen(navController = navController, userRepository = userRepository) }
//        composable("login_successful_screen") { LoginSuccessfulScreen(navController = navController) }
//        composable("meal_magic_screen") { backStackEntry ->
//            val userName = backStackEntry.arguments?.getString("userName") ?: "User"
//            MealMagicScreen(navController = navController, userName = userName)
//        }
//        composable("recipe_list?ingredients={ingredients}") { backStackEntry ->
//            val ingredients = backStackEntry.arguments?.getString("ingredients")?.split(",") ?: emptyList()
//            RecipeListScreen(navController = navController, ingredients = ingredients, recipeRepository = recipeRepository)
//        }
//        composable("recipe_details/{recipeName}") { backStackEntry ->
//            val recipeName = backStackEntry.arguments?.getString("recipeName") ?: ""
//            RecipeDetailScreen(recipeName = recipeName, recipeRepository = recipeRepository)
//        }
//        composable("delete_recipes?ingredients={ingredients}") { backStackEntry ->
//            val ingredients = backStackEntry.arguments?.getString("ingredients")?.split(",") ?: emptyList()
//            val recipeViewModel: RecipeViewModel = viewModel(factory = RecipeViewModelFactory(recipeRepository))
//            recipeViewModel.deleteRecipesByIngredients(ingredients)
//            navController.navigate("recipe_list?ingredients=${ingredients.joinToString(",")}")
//        }
//    }
//}
package com.example.saadat

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigator(userRepository: UserRepository, recipeRepository: RecipeRepository) {
    val navController = rememberNavController()
    val recipeViewModel: RecipeViewModel = viewModel(factory = RecipeViewModelFactory(recipeRepository))

    NavHost(navController = navController, startDestination = "background_image_1") {
        composable("background_image_1") { BackGroundImageScreen1(navController) }
        composable("background_image_2") { BackGroundImagesScreen2(navController) }
        composable("background_image_3") { BackGroundImagesScreen3(navController) }
        composable("sign_in_screen") { SignInScreen(navController = navController, userRepository = userRepository) }
        composable("sign_up_screen") { SignUpScreen(navController = navController, userRepository = userRepository) }
        composable("login_successful_screen") { LoginSuccessfulScreen(navController = navController) }
        composable("meal_magic_screen") { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName") ?: "User"
            MealMagicScreen(navController = navController, userName = userName, recipeViewModel = recipeViewModel)
        }
        composable("recipe_list?ingredients={ingredients}") { backStackEntry ->
            val ingredients = backStackEntry.arguments?.getString("ingredients")?.split(",") ?: emptyList()
            RecipeListScreen(navController = navController, ingredients = ingredients, recipeRepository = recipeRepository)
        }
        composable("recipe_details/{recipeName}") { backStackEntry ->
            val recipeName = backStackEntry.arguments?.getString("recipeName") ?: ""
            RecipeDetailScreen(recipeName = recipeName, recipeRepository = recipeRepository)
        }
    }
}
