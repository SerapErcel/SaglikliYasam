package com.serapercel.saglikliyasam.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.serapercel.saglikliyasam.service.RecipeClickListener
import com.serapercel.saglikliyasam.databinding.CardCellBinding
import com.serapercel.saglikliyasam.model.Recipe

class CardAdapter(
    private val recipes: List<Recipe>,
    private val clickListener: RecipeClickListener
) : RecyclerView.Adapter<CardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = CardCellBinding.inflate(from, parent, false)
        return CardViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bindRecipe(recipes[position])
    }

    override fun getItemCount(): Int = recipes.size
}