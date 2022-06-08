package com.serapercel.saglikliyasam.model

import androidx.room.Entity

var exerciseList = mutableListOf<Exercise>()

@Entity
class Exercise(
    var cover: Int,
    var name: String,
    var time: String,
    var description: String,
    val id: Int? = exerciseList.size
)