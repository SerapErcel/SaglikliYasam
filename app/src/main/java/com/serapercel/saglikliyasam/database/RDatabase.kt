package com.serapercel.saglikliyasam.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.serapercel.saglikliyasam.model.Exercise
import com.serapercel.saglikliyasam.model.Meal
import com.serapercel.saglikliyasam.model.Medicine
import com.serapercel.saglikliyasam.model.Recipe

@Database(entities = [Recipe::class, Exercise::class, Medicine::class, Meal::class], version = 1, exportSchema = false)
abstract class RDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDAO
    abstract fun exerciseDao(): ExerciseDAO
    abstract fun medicinesDao(): MedicineDAO
    abstract fun mealDao(): MealDAO

    // Singleton
    companion object {

        @Volatile
        private var instance: RDatabase? = null
        private val lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            RDatabase::class.java,
            "Database"
        ).build()

    }
}