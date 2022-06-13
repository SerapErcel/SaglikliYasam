package com.serapercel.saglikliyasam.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Medicines")
data class Medicine(
    @ColumnInfo(name = "medicineName")
    @SerializedName("isim")
    var name: String,
    @ColumnInfo(name = "medicineTime")
    @SerializedName("sure")
    var time: String,
) {

    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0

}