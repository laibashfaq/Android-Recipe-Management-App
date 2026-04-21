//// RecipeViewModel.kt
//package com.example.saadat
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//
//class RecipeViewModel(private val recipeRepository: RecipeRepository) : ViewModel() {
//
//    private val _recipe = MutableStateFlow<Recipe?>(null)
//    val recipe: StateFlow<Recipe?> = _recipe
//
//    fun getRecipeByName(recipeName: String) {
//        viewModelScope.launch {
//            recipeRepository.getRecipeByName(recipeName).collect {
//                _recipe.value = it
//            }
//        }
//    }
//}
//
//class RecipeViewModelFactory(private val recipeRepository: RecipeRepository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(RecipeViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return RecipeViewModel(recipeRepository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}
package com.example.saadat

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RecipeViewModel(private val recipeRepository: RecipeRepository) : ViewModel() {

    private val _recipe = MutableStateFlow<Recipe?>(null)
    val recipe: StateFlow<Recipe?> = _recipe

    fun getRecipeByName(recipeName: String) {
        viewModelScope.launch {
            recipeRepository.getRecipeByName(recipeName).collect {
                _recipe.value = it
            }
        }
    }

    fun deleteRecipesByIngredients(ingredients: List<String>) {
        viewModelScope.launch {
            Log.d("RecipeViewModel", "Deleting recipes with ingredients: $ingredients")
            recipeRepository.deleteRecipesByIngredients(ingredients)
        }
    }
}

class RecipeViewModelFactory(private val recipeRepository: RecipeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RecipeViewModel(recipeRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
