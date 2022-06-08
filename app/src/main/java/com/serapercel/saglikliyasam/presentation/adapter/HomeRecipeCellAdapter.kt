package com.serapercel.saglikliyasam.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.serapercel.saglikliyasam.databinding.HomeRecipeCellBinding
import com.serapercel.saglikliyasam.model.Recipe
import com.serapercel.saglikliyasam.util.listener.RecipeClickListener

class HomeRecipeCellAdapter(
    private val recipes: List<Recipe>,
    private val clickListener: RecipeClickListener
) : RecyclerView.Adapter<HomeRecipeCellHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecipeCellHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = HomeRecipeCellBinding.inflate(from, parent, false)
        return HomeRecipeCellHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: HomeRecipeCellHolder, position: Int) {
        holder.bindRecipe(recipes[position])
    }

    override fun getItemCount(): Int = recipes.size
}