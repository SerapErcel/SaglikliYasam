package com.serapercel.saglikliyasam.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.serapercel.saglikliyasam.model.Recipe

@Dao
interface RecipeDAO {
    //Data Access Object
    @Insert
    suspend fun insertAll(vararg recipe: Recipe): List<Long>

    @Query("SELECT * FROM Recipe")
    suspend fun getAllRecipe(): List<Recipe>

    @Query("SELECT * FROM Recipe WHERE uuid = :recipeId")
    suspend fun getRecipe(recipeId: Int): Recipe

    @Query("DELETE FROM Recipe")
    suspend fun deleteAllRecipe()
}