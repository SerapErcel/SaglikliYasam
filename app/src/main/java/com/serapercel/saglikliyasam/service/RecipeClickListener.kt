package com.serapercel.saglikliyasam.service

import com.serapercel.saglikliyasam.model.Recipe

interface RecipeClickListener {
    fun onClick(recipe: Recipe)
}