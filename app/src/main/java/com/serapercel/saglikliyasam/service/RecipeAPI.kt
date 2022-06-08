package com.serapercel.saglikliyasam.service

import com.serapercel.saglikliyasam.model.Recipe
import io.reactivex.Single
import retrofit2.http.GET

interface RecipeAPI {
    @GET("sercel23/SaglikliTariflerJSON/master/saglikliTarifler.json")
    fun getRecipe(): Single<List<Recipe>>
}