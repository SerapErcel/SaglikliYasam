package com.serapercel.saglikliyasam.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Meals")
data class Meal(
    @ColumnInfo(name = "mealName")
    var name: String,
    @ColumnInfo(name = "mealTime")
    var time: String,
) {

    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0

}