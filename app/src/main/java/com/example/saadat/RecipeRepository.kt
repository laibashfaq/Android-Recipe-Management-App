////RecipeRepository.kt
//package com.example.saadat
//
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.flow
//
//class RecipeRepository(private val recipeDao: RecipeDao) {
//
//    suspend fun insertRecipes(recipes: List<Recipe>) {
//        recipeDao.insertRecipe(recipes)
//    }
//
//    suspend fun getRecipesByIngredients(ingredient: String): List<Recipe> {
//        return recipeDao.getRecipesByIngredient(ingredient)
//    }
//
//
//    fun getRecipeByName(recipeName: String): Flow<Recipe?> = flow {
//        emit(recipeDao.getRecipeByName(recipeName))
//    }
//    suspend fun clear() {
//        recipeDao.clear()
//    }
//
//}
package com.example.saadat

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RecipeRepository(private val recipeDao: RecipeDao) {

    suspend fun insertRecipes(recipes: List<Recipe>) {
        recipeDao.insertRecipe(recipes)
    }

    suspend fun getRecipesByIngredients(ingredient: String): List<Recipe> {
        return recipeDao.getRecipesByIngredient(ingredient)
    }

    fun getRecipeByName(recipeName: String): Flow<Recipe?> = flow {
        emit(recipeDao.getRecipeByName(recipeName))
    }

    suspend fun clear() {
        recipeDao.clear()
    }

    suspend fun deleteRecipesByIngredients(ingredients: List<String>) {
        Log.d("RecipeRepository", "Repository deleting recipes with ingredients: $ingredients")
        recipeDao.deleteRecipesByIngredients(ingredients)
    }
}
