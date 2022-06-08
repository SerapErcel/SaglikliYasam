package com.serapercel.saglikliyasam.database

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class RecipeSharedPreferences {

    companion object {
        private const val TIME = "time"
        private var sharedPreferences: SharedPreferences? = null

        @Volatile
        private var instance: RecipeSharedPreferences? = null

        private val lock = Any()
        operator fun invoke(context: Context): RecipeSharedPreferences = instance ?: synchronized(
            lock
        ) {
            instance ?: createRecipeSharedPreference(context).also {
                instance = it
            }
        }

        private fun createRecipeSharedPreference(context: Context): RecipeSharedPreferences {
            sharedPreferences =
                androidx.preference.PreferenceManager.getDefaultSharedPreferences(context)
            return RecipeSharedPreferences()
        }

    }

    fun saveTime(time: Long) {
        sharedPreferences?.edit(commit = true) {
            putLong(TIME, time)
        }
    }

    fun getTime() = sharedPreferences?.getLong(TIME, 0)

}