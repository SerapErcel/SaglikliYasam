package com.serapercel.saglikliyasam.model

var exerciseList = mutableListOf<Exercise>()

val EXERCISE_ID_EXTRA = "exerciseExtra"

class Exercise(
    var cover: Int,
    var name: String,
    var time: String,
    var description: String,
    val id: Int? = exerciseList.size
)