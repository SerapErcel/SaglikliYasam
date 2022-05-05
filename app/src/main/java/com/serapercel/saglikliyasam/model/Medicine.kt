package com.serapercel.saglikliyasam.model

var medicineList = mutableListOf<Medicine>()

class Medicine(
    var name: String,
    var time: String,
    val id: Int? = exerciseList.size
)