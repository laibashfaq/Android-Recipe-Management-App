//// RecipeDao.kt
//package com.example.saadat
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import kotlinx.coroutines.flow.Flow
//
//@Dao
//interface RecipeDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertRecipe(recipe: kotlin.collections.List<com.example.saadat.Recipe>)
//
//
//
//    @Query("SELECT * FROM recipe WHERE ingredients LIKE '%' || :ingredient || '%'")
//    suspend fun getRecipesByIngredient(ingredient: String): List<Recipe>
//
//    @Query("DELETE FROM recipe")
//    suspend fun clear()
//
//    @Query("SELECT * FROM recipe WHERE name = :recipeName")
//    suspend fun getRecipeByName(recipeName: String): Recipe?
//
//    @Query("SELECT * FROM recipe WHERE ingredients IN (:ingredients)")
//    suspend fun getRecipesByIngredients(ingredients: List<String>): List<Recipe>
//}
package com.example.saadat

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipe: List<Recipe>)

    @Query("SELECT * FROM recipe WHERE ingredients LIKE '%' || :ingredient || '%'")
    suspend fun getRecipesByIngredient(ingredient: String): List<Recipe>

    @Query("DELETE FROM recipe")
    suspend fun clear()


    @Query("SELECT * FROM recipe WHERE name = :recipeName")
    suspend fun getRecipeByName(recipeName: String): Recipe?

    @Query("SELECT * FROM recipe WHERE ingredients IN (:ingredients)")
    suspend fun getRecipesByIngredients(ingredients: List<String>): List<Recipe>

    @Query("DELETE FROM recipe WHERE ingredients IN (:ingredients)")
    suspend fun deleteRecipesByIngredients(ingredients: List<String>)
}
