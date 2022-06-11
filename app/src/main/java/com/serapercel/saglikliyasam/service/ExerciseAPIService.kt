package com.serapercel.saglikliyasam.service

import com.serapercel.saglikliyasam.model.Exercise
import com.serapercel.saglikliyasam.util.Constant.BASE_URL
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ExerciseAPIService {

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(ExerciseAPI::class.java)

    fun getExerciseData(): Single<List<Exercise>> {
        return api.getExercise()
    }

}