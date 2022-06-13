package com.serapercel.saglikliyasam.presentation.ui.fragment.meal_add

import android.app.Application
import com.serapercel.saglikliyasam.database.RDatabase
import com.serapercel.saglikliyasam.model.Meal
import com.serapercel.saglikliyasam.util.base.BaseViewModel
import kotlinx.coroutines.launch

class MealAddViewModel(application: Application) : BaseViewModel(application) {

    fun storeInSQLite(meal: Meal) {
        launch {
            val dao = RDatabase(getApplication()).mealDao()
            dao.insertMeal(meal)
        }
    }

}