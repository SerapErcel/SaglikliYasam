package com.serapercel.saglikliyasam.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Exercise")
data class Exercise(
    @ColumnInfo(name = "exerciseName")
    @SerializedName("isim")
    var name: String,
    @ColumnInfo(name = "exerciseRepeat")
    @SerializedName("tekrar")
    var repeat: String,
    @ColumnInfo(name = "exerciseDescription")
    @SerializedName("aciklama")
    var description: String,
    @ColumnInfo(name = "exercise")
    @SerializedName("uygulama")
    var exercise: String,
    @ColumnInfo(name = "exerciseImage")
    @SerializedName("gorsel")
    val exerciseImage: String?,
) {

    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0

}