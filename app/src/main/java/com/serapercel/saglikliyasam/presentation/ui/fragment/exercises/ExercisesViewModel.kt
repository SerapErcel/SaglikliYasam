package com.serapercel.saglikliyasam.presentation.ui.fragment.exercises

import androidx.lifecycle.ViewModel
import com.serapercel.saglikliyasam.R
import com.serapercel.saglikliyasam.model.Exercise
import com.serapercel.saglikliyasam.model.exerciseList

class ExercisesViewModel : ViewModel() {
    // todo "change mock data with real data"
    fun populateExercises() {
        val exercise1 = Exercise(
            R.drawable.patlican_pizza,
            name = "Isınma Egzersizi",
            time = "3 dakika",
            description = "Isınma egzersizini verilen süre boyunca bulunduğunuz yerde tekrar tekar uygulayınız. "
        )
        exerciseList.add(exercise1)
        exerciseList.add(exercise1)
        exerciseList.add(exercise1)
        exerciseList.add(exercise1)
        exerciseList.add(exercise1)
        exerciseList.add(exercise1)
    }
}