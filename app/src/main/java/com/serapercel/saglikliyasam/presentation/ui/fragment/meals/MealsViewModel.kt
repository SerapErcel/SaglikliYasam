package com.serapercel.saglikliyasam.presentation.ui.fragment.meals

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.serapercel.saglikliyasam.database.RDatabase
import com.serapercel.saglikliyasam.model.Meal
import com.serapercel.saglikliyasam.util.base.BaseViewModel
import kotlinx.coroutines.launch

class MealsViewModel(application: Application) : BaseViewModel(application) {

    val meals = MutableLiveData<List<Meal>>()

    fun getDataFromSQLite() {
        launch {
            val mealList = RDatabase(getApplication()).mealDao().getAllMeal()
            showMeals(mealList)
        }
    }

    private fun showMeals(mealList: List<Meal>) {
        meals.value = mealList

    }
}