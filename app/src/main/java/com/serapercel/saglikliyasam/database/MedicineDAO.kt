package com.serapercel.saglikliyasam.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.serapercel.saglikliyasam.model.Medicine

@Dao
interface MedicineDAO {

    //Data Access Object

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMedicine(vararg medicine: Medicine)

    @Insert
    suspend fun insertAllMedicine(vararg medicines: Medicine): List<Long>

    @Query("SELECT * FROM Medicines")
    suspend fun getAllMedicine(): List<Medicine>

    @Query("SELECT * FROM Medicines WHERE uuid = :medicineID")
    suspend fun getMedicine(medicineID: Int): Medicine

    @Query("DELETE FROM Medicines")
    suspend fun deleteAllMedicine()
}