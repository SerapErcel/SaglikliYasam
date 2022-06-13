package com.serapercel.saglikliyasam.presentation.ui.fragment.medicine_add

import android.app.Application
import com.serapercel.saglikliyasam.database.RDatabase
import com.serapercel.saglikliyasam.model.Medicine
import com.serapercel.saglikliyasam.util.base.BaseViewModel
import kotlinx.coroutines.launch

class MedicineAddViewModel(application: Application) : BaseViewModel(application) {

    fun storeInSQLite(medicine: Medicine) {
        launch {
            val dao = RDatabase(getApplication()).medicinesDao()
            dao.insertMedicine(medicine)
        }
    }

}