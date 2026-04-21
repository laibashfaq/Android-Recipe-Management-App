//
//package com.example.saadat
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.runBlocking
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        val database by lazy { AppDatabase.getDatabase(this, CoroutineScope(Dispatchers.IO)) }
//        val userRepository by lazy { UserRepository(database.userDao()) }
//        val recipeRepository by lazy { RecipeRepository(database.recipeDao()) }
//
//        runBlocking {
//            // Populating database synchronously for simplicity in this example
//            AppDatabase.populateDatabase(database)
//        }
//
//        setContent {
//            AppNavigator(userRepository = userRepository, recipeRepository = recipeRepository)
//        }
//    }
//}
package com.example.saadat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MainActivity : ComponentActivity() {

    private val applicationScope = CoroutineScope(Dispatchers.Default)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val database = AppDatabase.getDatabase(this, applicationScope)
            val userRepository = UserRepository(database.userDao())
            val recipeRepository = RecipeRepository(database.recipeDao())

            AppNavigator(userRepository = userRepository, recipeRepository = recipeRepository)
        }
    }
}
