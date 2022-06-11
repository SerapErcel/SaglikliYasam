package com.serapercel.saglikliyasam.presentation.ui.fragment.recipe_detail

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.serapercel.saglikliyasam.database.RDatabase
import com.serapercel.saglikliyasam.model.Recipe
import com.serapercel.saglikliyasam.util.base.BaseViewModel
import kotlinx.coroutines.launch

class RecipeDetailViewModel(application: Application) : BaseViewModel(application) {

    val recipeLiveData = MutableLiveData<Recipe>()

    fun getRecipeFromRoom(uuid: Int) {
        launch {
            val dao = RDatabase(getApplication()).recipeDao()
            val recipe = dao.getRecipe(uuid)
            recipeLiveData.value = recipe
        }
    }

}