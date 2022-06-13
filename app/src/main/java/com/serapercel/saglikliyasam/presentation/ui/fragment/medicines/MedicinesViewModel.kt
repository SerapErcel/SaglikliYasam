package com.serapercel.saglikliyasam.presentation.ui.fragment.medicines

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.serapercel.saglikliyasam.database.RDatabase
import com.serapercel.saglikliyasam.model.Medicine
import com.serapercel.saglikliyasam.util.base.BaseViewModel
import kotlinx.coroutines.launch

class MedicinesViewModel(application: Application) : BaseViewModel(application) {

    val medicines = MutableLiveData<List<Medicine>>()

    fun getDataFromSQLite() {
        launch {
            val medicineList = RDatabase(getApplication()).medicinesDao().getAllMedicine()
            showMedicines(medicineList)
        }
    }

    private fun showMedicines(medicineList: List<Medicine>) {
        medicines.value = medicineList

    }
}
