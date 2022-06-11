package com.serapercel.saglikliyasam.database

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class SharedPreferences {

    companion object {
        private const val TimeRecipe = "timeRecipe"
        private const val TimeExercise = "timeExercise"

        private var sharedPreferences: SharedPreferences? = null

        @Volatile
        private var instance: com.serapercel.saglikliyasam.database.SharedPreferences? = null

        private val lock = Any()
        operator fun invoke(context: Context): com.serapercel.saglikliyasam.database.SharedPreferences =
            instance ?: synchronized(
                lock
            ) {
                instance ?: createSharedPreference(context).also {
                    instance = it
                }
            }

        private fun createSharedPreference(context: Context): com.serapercel.saglikliyasam.database.SharedPreferences {
            sharedPreferences =
                androidx.preference.PreferenceManager.getDefaultSharedPreferences(context)
            return SharedPreferences()
        }

    }

    fun saveTimeRecipe(time: Long) {
        sharedPreferences?.edit(commit = true) {
            putLong(TimeRecipe, time)
        }
    }

    fun getTimeRecipe() = sharedPreferences?.getLong(TimeRecipe, 0)
    fun saveTimeExercise(time: Long) {
        sharedPreferences?.edit(commit = true) {
            putLong(TimeExercise, time)
        }
    }

    fun getTimeExercise() = sharedPreferences?.getLong(TimeExercise, 0)
}