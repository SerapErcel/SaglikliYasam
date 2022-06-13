package com.serapercel.saglikliyasam.presentation.adapter.medicineAdapter

import androidx.recyclerview.widget.RecyclerView
import com.serapercel.saglikliyasam.databinding.MedicineRecyclerRowBinding
import com.serapercel.saglikliyasam.model.Medicine

class MedicineHolder(
    private val medicinesBinding: MedicineRecyclerRowBinding,

    ) : RecyclerView.ViewHolder(medicinesBinding.root) {

    fun bindMedicine(medicine: Medicine) {
        medicinesBinding.medicineText.text = medicine.name
        medicinesBinding.timeText.text = medicine.time

    }
}