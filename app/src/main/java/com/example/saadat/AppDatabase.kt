//package com.example.saadat
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import androidx.sqlite.db.SupportSQLiteDatabase
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.launch
//
//@Database(entities = [User::class, Recipe::class], version = 1)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun userDao(): UserDao
//    abstract fun recipeDao(): RecipeDao
//
//    companion object {
//        @Volatile
//        private var INSTANCE: AppDatabase? = null
//
//        fun getDatabase(context: Context, scope: CoroutineScope): AppDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java,
//                    "app_database"
//                )
//                    .addCallback(AppDatabaseCallback(scope))
//                    .build()
//                INSTANCE = instance
//                instance
//            }
//        }
//
//        private class AppDatabaseCallback(
//            private val scope: CoroutineScope
//        ) : Callback() {
//            override fun onCreate(db: SupportSQLiteDatabase) {
//                super.onCreate(db)
//                INSTANCE?.let { database ->
//                    scope.launch {
//                        populateDatabase(database)
//                    }
//                }
//            }
//        }
//
//        suspend fun populateDatabase(database: AppDatabase) {
//            val recipeDao = database.recipeDao()
//            // Populate with sample data
//            val recipes = listOf(
//                Recipe(1, "Pasta", "Noodles, Tomato Sauce, Cheese", "Boil noodles. Add sauce. Sprinkle cheese."),
//                Recipe(2, "Salad", "Lettuce, Tomato, Cucumber", "Chop and mix all ingredients."),
//                Recipe(3, "Pizza", "Dough, Tomato Sauce, Cheese, Pepperoni", "Spread sauce on dough. Add cheese and pepperoni. Bake."),
//                Recipe(4, "Burger", "Buns, Beef Patty, Lettuce, Tomato, Cheese", "Grill patty. Assemble with buns and other ingredients."),
//                Recipe(5, "Sandwich", "Bread, Ham, Cheese, Lettuce, Tomato", "Assemble ingredients between slices of bread."),
//                Recipe(6, "Soup", "Chicken, Carrots, Celery, Broth", "Boil chicken and vegetables in broth."),
//                Recipe(7, "Tacos", "Tortillas, Beef, Lettuce, Cheese, Salsa", "Cook beef. Assemble in tortillas with other ingredients."),
//                Recipe(8, "Pancakes", "Flour, Eggs, Milk, Butter, Syrup", "Mix ingredients and cook on a griddle."),
//                Recipe(9, "Omelette", "Eggs, Cheese, Ham, Peppers, Onions", "Beat eggs and cook with fillings in a pan."),
//                Recipe(10, "Spaghetti", "Pasta, Tomato Sauce, Meatballs", "Cook pasta and meatballs. Serve with sauce."),
//                Recipe(11, "Fried Rice", "Rice, Eggs, Peas, Carrots, Soy Sauce", "Cook rice with vegetables and soy sauce."),
//                Recipe(12, "Curry", "Chicken, Curry Powder, Coconut Milk, Vegetables", "Cook chicken and vegetables with curry and coconut milk."),
//                Recipe(13, "Steak", "Beef, Salt, Pepper, Garlic Butter", "Season steak and cook to desired doneness."),
//                Recipe(14, "Fish and Chips", "Fish, Potatoes, Flour, Oil", "Fry battered fish and potatoes."),
//                Recipe(15, "BBQ Ribs", "Ribs, BBQ Sauce, Spices", "Season ribs and cook with BBQ sauce."),
//                Recipe(16, "Mac and Cheese", "Macaroni, Cheese, Milk, Butter", "Cook macaroni and mix with cheese sauce."),
//                Recipe(17, "Lasagna", "Lasagna Noodles, Ricotta, Meat Sauce, Cheese", "Layer noodles with sauce and cheese. Bake."),
//                Recipe(18, "Chili", "Ground Beef, Beans, Tomatoes, Spices", "Cook beef with beans and spices."),
//                Recipe(19, "Chicken Wings", "Chicken Wings, Hot Sauce, Butter", "Cook wings and toss in hot sauce."),
//                Recipe(20, "Quiche", "Pie Crust, Eggs, Cheese, Spinach, Bacon", "Mix eggs with fillings and bake in crust."),
//                Recipe(21, "Stir Fry", "Chicken, Broccoli, Soy Sauce, Ginger, Garlic", "Cook chicken and vegetables with sauce."),
//                Recipe(22, "Sushi", "Rice, Nori, Fish, Vegetables", "Roll rice and fillings in nori."),
//                Recipe(23, "Burrito", "Tortilla, Rice, Beans, Meat, Cheese, Salsa", "Wrap fillings in tortilla."),
//                Recipe(24, "Pad Thai", "Rice Noodles, Shrimp, Peanuts, Bean Sprouts, Sauce", "Cook noodles with shrimp and sauce."),
//                Recipe(25, "Minestrone", "Pasta, Beans, Vegetables, Broth", "Cook pasta and vegetables in broth."),
//                Recipe(26, "Goulash", "Beef, Paprika, Potatoes, Carrots", "Cook beef and vegetables with paprika."),
//                Recipe(27, "Gazpacho", "Tomatoes, Cucumbers, Peppers, Garlic, Vinegar", "Blend ingredients and serve cold."),
//                Recipe(28, "Falafel", "Chickpeas, Garlic, Parsley, Spices", "Blend ingredients and fry."),
//                Recipe(29, "Shepherd's Pie", "Ground Beef, Vegetables, Mashed Potatoes", "Layer meat and vegetables with potatoes and bake."),
//                Recipe(30, "Peking Duck", "Duck, Hoisin Sauce, Pancakes, Scallions", "Roast duck and serve with pancakes and sauce.")
//            )
//            recipes.forEach { recipe ->
//                recipeDao.insertRecipe(recipe)
//            }
//        }
//    }
//}
package com.example.saadat

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [User::class, Recipe::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun recipeDao(): RecipeDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .addCallback(AppDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private class AppDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    scope.launch {
                        populateDatabase(database)
                    }
                }
            }
        }

        suspend fun populateDatabase(database: AppDatabase) {
            val recipeDao = database.recipeDao()
            // Populate with sample data
            val recipes = listOf(
                Recipe(1, "Pasta", "Noodles, Tomato Sauce, Cheese", "Boil noodles. Add sauce. Sprinkle cheese."),
                Recipe(2, "Salad", "Lettuce, Tomato, Cucumber", "Chop and mix all ingredients."),
                // Add more recipes as needed
                Recipe(3, "Pizza", "Dough, Tomato Sauce, Cheese, Pepperoni", "Prepare dough. Add sauce, cheese, and toppings. Bake."),
                Recipe(4, "Soup", "Broth, Chicken, Vegetables", "Simmer broth with chicken and vegetables."),
                Recipe(5, "Sandwich", "Bread, Lettuce, Tomato, Turkey", "Assemble ingredients between slices of bread."),
                Recipe(6, "Smoothie", "Banana, Berries, Yogurt", "Blend all ingredients until smooth."),
                Recipe(7, "Omelette", "Eggs, Cheese, Vegetables", "Beat eggs, add cheese and vegetables, and cook."),
                Recipe(8, "Burger", "Beef Patty, Bun, Lettuce, Tomato", "Grill patty and assemble burger."),
                Recipe(9, "Tacos", "Tortilla, Beef, Lettuce, Cheese", "Cook beef, assemble ingredients in tortilla."),
                Recipe(10, "Curry", "Chicken, Curry Sauce, Rice", "Cook chicken with curry sauce, serve with rice."),
                Recipe(11, "Pancakes", "Flour, Eggs, Milk", "Mix ingredients and cook on a griddle."),
                Recipe(12, "Steak", "Beef, Salt, Pepper", "Season steak and grill to desired doneness."),
                Recipe(13, "Spaghetti", "Pasta, Tomato Sauce, Meatballs", "Cook pasta, add sauce and meatballs."),
                Recipe(14, "Fried Rice", "Rice, Vegetables, Soy Sauce", "Stir-fry rice with vegetables and soy sauce."),
                Recipe(15, "Sushi", "Rice, Seaweed, Fish", "Assemble sushi rolls with rice and fish."),
                Recipe(16, "Mac and Cheese", "Pasta, Cheese Sauce", "Cook pasta, add cheese sauce."),
                Recipe(17, "Stir Fry", "Vegetables, Soy Sauce, Chicken", "Stir-fry chicken and vegetables with soy sauce."),
                Recipe(18, "Brownies", "Chocolate, Flour, Sugar", "Mix ingredients and bake."),
                Recipe(19, "Chili", "Beans, Tomato Sauce, Ground Beef", "Simmer all ingredients together."),
                Recipe(20, "Lasagna", "Pasta, Cheese, Tomato Sauce, Meat", "Layer ingredients and bake.")
            )
            recipes.forEach { recipe ->
                recipeDao.insertRecipe(recipes)
            }
        }
    }
}
