package com.serapercel.saglikliyasam.presentation.adapter.mealCardAdapter

import androidx.recyclerview.widget.RecyclerView
import com.serapercel.saglikliyasam.databinding.MealRecyclerRowBinding
import com.serapercel.saglikliyasam.model.Meal

class MealHolder(val binding: MealRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindMeal(meal: Meal) {
        binding.mealText.text = meal.name
        binding.mealTimeText.text = meal.time
    }
}