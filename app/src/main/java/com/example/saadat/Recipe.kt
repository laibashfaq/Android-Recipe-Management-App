//Recipe.kt
package com.example.saadat

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe")
data class Recipe(
    @PrimaryKey val id: Int,
    val name: String,
    val ingredients: String,
    val instructions: String
)
