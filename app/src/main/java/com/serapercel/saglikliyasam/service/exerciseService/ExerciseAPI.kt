package com.serapercel.saglikliyasam.service.exerciseService

import com.serapercel.saglikliyasam.model.Exercise
import io.reactivex.Single
import retrofit2.http.GET

interface ExerciseAPI {

    @GET("sercel23/EgzersizlerJSON/master/exercisess.json")
    fun getExercise(): Single<List<Exercise>>

}