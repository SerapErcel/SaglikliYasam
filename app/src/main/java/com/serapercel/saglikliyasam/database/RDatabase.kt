package com.serapercel.saglikliyasam.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.serapercel.saglikliyasam.model.Exercise
import com.serapercel.saglikliyasam.model.Recipe

@Database(entities = [Recipe::class, Exercise::class], version = 1, exportSchema = false)
abstract class RDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDAO
    abstract fun exerciseDao(): ExerciseDAO

    // Singleton
    companion object {

        @Volatile
        private var instance: com.serapercel.saglikliyasam.database.RDatabase? = null
        private val lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: createDatabaseRecipe(context).also {
                instance = it
            }
        }

        private fun createDatabaseRecipe(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            RDatabase::class.java,
            "Recipe"
        ).build()

        private fun createDatabaseExercise(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            RDatabase::class.java,
            "Exercise"
        ).build()
    }
}