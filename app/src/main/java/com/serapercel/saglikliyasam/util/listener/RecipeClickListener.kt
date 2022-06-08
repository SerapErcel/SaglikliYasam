package com.serapercel.saglikliyasam.util.listener

import com.serapercel.saglikliyasam.model.Recipe

interface RecipeClickListener {
    fun onClick(recipe: Recipe)
}