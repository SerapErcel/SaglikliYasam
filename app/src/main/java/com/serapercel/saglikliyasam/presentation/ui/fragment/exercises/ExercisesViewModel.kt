package com.serapercel.saglikliyasam.presentation.ui.fragment.exercises

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.serapercel.saglikliyasam.database.RDatabase
import com.serapercel.saglikliyasam.database.SharedPreferences
import com.serapercel.saglikliyasam.model.Exercise
import com.serapercel.saglikliyasam.service.ExerciseAPIService
import com.serapercel.saglikliyasam.util.base.BaseViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.launch

class ExercisesViewModel(application: Application) : BaseViewModel(application) {

    val exercises = MutableLiveData<List<Exercise>>()
    val exerciseErrorMessage = MutableLiveData<Boolean>()
    val exerciseDownloading = MutableLiveData<Boolean>()

    private var updateTime = 10 * 60 * 1000 * 1000 * 1000L
    private val exerciseAPIService = ExerciseAPIService()
    private val disposable = CompositeDisposable()
    private val SharedPreferences = SharedPreferences(getApplication())

    fun refreshData() {
        val saveTime = SharedPreferences.getTime()
        if (saveTime != null && saveTime != 0L && System.nanoTime() - saveTime < updateTime) {
            getDataFromSQLite()
        } else {
            getDataFromInternet()
        }
    }

    private fun getDataFromInternet() {
        TODO("Not yet implemented")
    }

    private fun getDataFromSQLite() {
        exerciseDownloading.value = true
        launch {
            val exerciseList = RDatabase(getApplication()).exerciseDao().getAllExercise()
            showExercises(exerciseList)
        }
    }

    private fun showExercises(exerciseList: List<Exercise>) {
        exercises.value = exerciseList
        exerciseErrorMessage.value = false
        exerciseDownloading.value = false
    }
}