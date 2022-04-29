package com.serapercel.saglikliyasam.util

import com.serapercel.saglikliyasam.model.Recipe

interface RecipeClickListener {
    fun onClick(recipe: Recipe)
}