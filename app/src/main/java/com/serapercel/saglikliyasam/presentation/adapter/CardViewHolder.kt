package com.serapercel.saglikliyasam.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.serapercel.saglikliyasam.util.RecipeClickListener
import com.serapercel.saglikliyasam.databinding.CardCellBinding
import com.serapercel.saglikliyasam.model.Recipe

class CardViewHolder(
    private val cardCellBinding: CardCellBinding,
    private val clickListener: RecipeClickListener
) : RecyclerView.ViewHolder(cardCellBinding.root) {

    fun bindRecipe(recipe: Recipe) {
        cardCellBinding.cover.setImageResource(recipe.cover)
        cardCellBinding.title.text = recipe.name
        cardCellBinding.time.text = recipe.time

        cardCellBinding.cardView.setOnClickListener {
            clickListener.onClick(recipe)
        }
    }

}