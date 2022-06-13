package com.serapercel.saglikliyasam.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.serapercel.saglikliyasam.model.Meal

@Dao
interface MealDAO {

    //Data Access Object

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeal(vararg meal: Meal)

    @Insert
    suspend fun insertAllMeal(vararg meals: Meal): List<Long>

    @Query("SELECT * FROM Meals")
    suspend fun getAllMeal(): List<Meal>

    @Query("SELECT * FROM Meals WHERE uuid = :mealID")
    suspend fun getMeal(mealID: Int): Meal

    @Query("DELETE FROM Meals")
    suspend fun deleteMeal()
}