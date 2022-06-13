package com.serapercel.saglikliyasam.presentation.adapter.mealCardAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.serapercel.saglikliyasam.databinding.MealRecyclerRowBinding
import com.serapercel.saglikliyasam.model.Meal

class MealAdapter(
    private val meals: List<Meal>,
) : RecyclerView.Adapter<MealHolder>(

) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealHolder {
        val binding =
            MealRecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MealHolder(binding)
    }

    override fun onBindViewHolder(holder: MealHolder, position: Int) {
        holder.bindMeal(meals[position])
    }

    override fun getItemCount(): Int = meals.size

}