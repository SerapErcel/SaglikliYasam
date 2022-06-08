package com.serapercel.saglikliyasam.service

import com.serapercel.saglikliyasam.model.Recipe
import com.serapercel.saglikliyasam.util.Constant.BASE_URL
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RecipeAPIService {

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(RecipeAPI::class.java)

    fun getData(): Single<List<Recipe>> {
        return api.getRecipe()
    }

}