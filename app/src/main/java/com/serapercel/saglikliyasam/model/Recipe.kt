package com.serapercel.saglikliyasam.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

var recipeList = mutableListOf<Recipe>()

@Entity
data class Recipe(
    var cover: Int,
    @ColumnInfo(name = "isim")
    @SerializedName("isim")
    var name: String,
    @ColumnInfo(name = "sure")
    @SerializedName("sure")
    var time: String,
    @ColumnInfo(name = "malzemeler")
    @SerializedName("malzemeler")
    var necessaries: String,
    @ColumnInfo(name = "tarif")
    @SerializedName("tarif")
    var description: String,


    @ColumnInfo(name = "gorsel")
    @SerializedName("gorsel")
    val yemekGorsel: String?
) {

    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0

}

