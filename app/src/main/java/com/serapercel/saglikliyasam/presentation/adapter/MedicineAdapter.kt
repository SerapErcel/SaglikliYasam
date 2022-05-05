package com.serapercel.saglikliyasam.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.serapercel.saglikliyasam.databinding.MedicineRecyclerRowBinding
import com.serapercel.saglikliyasam.model.medicineList

class MedicineAdapter() :
    RecyclerView.Adapter<MedicineHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineHolder {
        val binding =
            MedicineRecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MedicineHolder(binding)
    }

    override fun onBindViewHolder(holder: MedicineHolder, position: Int) {
        holder.binding.medicineText.text = medicineList[position].name
        holder.binding.timeText.text = medicineList[position].time

    }

    override fun getItemCount(): Int {
        return medicineList.size
    }
}