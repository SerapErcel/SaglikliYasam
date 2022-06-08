package com.serapercel.saglikliyasam.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.serapercel.saglikliyasam.util.listener.RecipeClickListener
import com.serapercel.saglikliyasam.databinding.CardCellBinding
import com.serapercel.saglikliyasam.model.Recipe
import com.serapercel.saglikliyasam.util.downloadImage
import com.serapercel.saglikliyasam.util.placeHolder

class RecipeCardAdapter(
    private val recipes: List<Recipe>,
    private val clickListener: RecipeClickListener,
    private val context: Context
) : RecyclerView.Adapter<RecipeCardAdapter.CardViewHolder>() {

    class CardViewHolder(val itemBinding: CardCellBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding =
            CardCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.itemBinding.title.text = recipes[position].name
        holder.itemBinding.time.text = recipes[position].time

        holder.itemBinding.image.downloadImage(recipes[position].recipeImage, placeHolder(context))

        holder.itemBinding.cardView.setOnClickListener {
            clickListener.onClick(recipes[position])
        }
    }

    override fun getItemCount(): Int = recipes.size
}