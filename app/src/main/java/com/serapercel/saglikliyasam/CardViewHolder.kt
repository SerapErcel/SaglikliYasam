package com.serapercel.saglikliyasam

import androidx.recyclerview.widget.RecyclerView
import com.serapercel.saglikliyasam.databinding.CardCellBinding

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