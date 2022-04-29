package com.serapercel.saglikliyasam

var recipeList = mutableListOf<Recipe>()

val RECIPE_ID_EXTRA = "recipeExtra"

class Recipe(
    var cover: Int,
    var name: String,
    var time: String,
    var necessaries: String,
    var description: String,
    val id: Int? = recipeList.size
)