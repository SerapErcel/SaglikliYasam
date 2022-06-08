package com.serapercel.saglikliyasam.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Recipe(
    @ColumnInfo(name = "recipeName")
    @SerializedName("isim")
    var name: String,
    @ColumnInfo(name = "recipeTime")
    @SerializedName("sure")
    var time: String,
    @ColumnInfo(name = "recipeNecessaries")
    @SerializedName("malzemeler")
    var necessaries: String,
    @ColumnInfo(name = "recipeDescription")
    @SerializedName("tarif")
    var description: String,
    @ColumnInfo(name = "recipeImage")
    @SerializedName("gorsel")
    val recipeImage: String?
) {

    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0

}

