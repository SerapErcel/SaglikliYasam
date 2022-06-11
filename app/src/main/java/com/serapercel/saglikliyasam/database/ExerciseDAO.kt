package com.serapercel.saglikliyasam.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.serapercel.saglikliyasam.model.Exercise

@Dao
interface ExerciseDAO {
    //Data Access Object
    @Insert
    suspend fun insertAll(vararg exercise: Exercise): List<Long>

    @Query("SELECT * FROM Exercise")
    suspend fun getAllExercise(): List<Exercise>

    @Query("SELECT * FROM Exercise WHERE uuid = :exerciseId")
    suspend fun getExercise(exerciseId: Int): Exercise

    @Query("DELETE FROM Exercise")
    suspend fun deleteAllExercise()
}

