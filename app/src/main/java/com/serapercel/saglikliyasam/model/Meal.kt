package com.serapercel.saglikliyasam.model

var mealList = mutableListOf<Meal>()

class Meal(
    var name: String,
    var time: String,
    val id: Int? = mealList.size
)