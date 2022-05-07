package com.serapercel.saglikliyasam.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.serapercel.saglikliyasam.databinding.MealRecyclerRowBinding
import com.serapercel.saglikliyasam.model.mealList

class MealAdapter : RecyclerView.Adapter<MealHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealHolder {
        val binding =
            MealRecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MealHolder(binding)
    }

    override fun onBindViewHolder(holder: MealHolder, position: Int) {
        holder.binding.mealText.text = mealList[position].name
        holder.binding.mealTimeText.text = mealList[position].time
    }

    override fun getItemCount(): Int {
        return mealList.size
    }
}