package com.serapercel.saglikliyasam.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.serapercel.saglikliyasam.databinding.HomeRecipeCellBinding
import com.serapercel.saglikliyasam.model.Recipe
import com.serapercel.saglikliyasam.util.RecipeClickListener

class HomeRecipeCellHolder(
    private val cardCellBinding: HomeRecipeCellBinding,
    private val clickListener: RecipeClickListener
) : RecyclerView.ViewHolder(cardCellBinding.root) {

    fun bindRecipe(recipe: Recipe) {
        cardCellBinding.recipeCover.setImageResource(recipe.cover)
        cardCellBinding.title.text = recipe.name
        cardCellBinding.time.text = recipe.time

        cardCellBinding.recipeCardView.setOnClickListener {
            clickListener.onClick(recipe)
        }
    }

}