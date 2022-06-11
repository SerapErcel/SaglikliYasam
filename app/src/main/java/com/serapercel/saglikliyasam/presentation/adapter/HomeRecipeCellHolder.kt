package com.serapercel.saglikliyasam.presentation.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.serapercel.saglikliyasam.databinding.HomeRecipeCellBinding
import com.serapercel.saglikliyasam.model.Recipe
import com.serapercel.saglikliyasam.util.downloadImage
import com.serapercel.saglikliyasam.util.listener.RecipeClickListener
import com.serapercel.saglikliyasam.util.placeHolder

class HomeRecipeCellHolder(
    private val cardCellBinding: HomeRecipeCellBinding,
    private val clickListener: RecipeClickListener,
    private val context: Context
) : RecyclerView.ViewHolder(cardCellBinding.root) {

    fun bindRecipe(recipe: Recipe) {
       cardCellBinding.recipeCover.downloadImage(recipe.recipeImage, placeHolder(context))
        cardCellBinding.title.text = recipe.name
        cardCellBinding.time.text = recipe.time

        cardCellBinding.recipeCardView.setOnClickListener {
            clickListener.onClick(recipe)
        }
    }

}