package com.serapercel.saglikliyasam.presentation.ui.fragment.exercise_detail

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.serapercel.saglikliyasam.database.RDatabase
import com.serapercel.saglikliyasam.model.Exercise
import com.serapercel.saglikliyasam.util.base.BaseViewModel
import kotlinx.coroutines.launch

class ExerciseDetailViewModel(application: Application) : BaseViewModel(application) {

    val exerciseLiveData = MutableLiveData<Exercise>()

    fun getExerciseFromRoom(uuid: Int) {
        launch {
            val dao = RDatabase(getApplication()).exerciseDao()
            val exercise = dao.getExercise(uuid)
            exerciseLiveData.value = exercise
        }
    }

}