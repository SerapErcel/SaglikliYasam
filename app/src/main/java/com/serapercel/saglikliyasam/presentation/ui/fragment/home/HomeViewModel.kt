package com.serapercel.saglikliyasam.presentation.ui.fragment.home

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.serapercel.saglikliyasam.database.RDatabase
import com.serapercel.saglikliyasam.database.SharedPreferences
import com.serapercel.saglikliyasam.model.Exercise
import com.serapercel.saglikliyasam.model.Recipe
import com.serapercel.saglikliyasam.service.ExerciseAPIService
import com.serapercel.saglikliyasam.service.RecipeAPIService
import com.serapercel.saglikliyasam.util.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : BaseViewModel(application) {

    val exercises = MutableLiveData<List<Exercise>>()
    val exerciseErrorMessage = MutableLiveData<Boolean>()
    val exerciseDownloading = MutableLiveData<Boolean>()

    private var updateTime = 10 * 60 * 1000 * 1000 * 1000L
    private val exerciseAPIService = ExerciseAPIService()
    private val disposable = CompositeDisposable()
    private val SharedPreferences = SharedPreferences(getApplication())

    val recipes = MutableLiveData<List<Recipe>>()
    val recipeErrorMessage = MutableLiveData<Boolean>()
    val recipeDownloading = MutableLiveData<Boolean>()

    private val recipeAPIService = RecipeAPIService()
    private val recipeSharedPreferences = SharedPreferences(getApplication())


    fun refreshData() {
        val saveTime = SharedPreferences.getTimeExercise()
        if (saveTime != null && saveTime != 0L && System.nanoTime() - saveTime < updateTime) {
            getExerciseDataFromSQLite()
            getRecipeDataFromSQLite()

        } else {
            getExerciseDataFromInternet()
            getRecipeDataFromInternet()
        }
    }

    private fun getExerciseDataFromInternet() {
        exerciseDownloading.value = true
        disposable.add(
            exerciseAPIService.getExerciseData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Exercise>>() {
                    override fun onSuccess(t: List<Exercise>) {
                        storeExerciseInSQLite(t)
                        Toast.makeText(getApplication(), "Liste Güncellendi", Toast.LENGTH_SHORT)
                            .show()
                        exercises.value = t
                    }

                    override fun onError(e: Throwable) {
                        exerciseErrorMessage.value = true
                        exerciseDownloading.value = false
                        e.printStackTrace()
                    }
                })
        )

    }

    private fun getRecipeDataFromInternet() {
        recipeDownloading.value = true
        disposable.add(
            recipeAPIService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Recipe>>() {
                    override fun onSuccess(t: List<Recipe>) {
                        storeRecipeInSQLite(t)
                        Toast.makeText(getApplication(), "Liste Güncellendi", Toast.LENGTH_SHORT)
                            .show()
                        recipes.value = t
                    }

                    override fun onError(e: Throwable) {
                        recipeErrorMessage.value = true
                        recipeDownloading.value = false
                        e.printStackTrace()
                    }
                })
        )
    }

    private fun storeExerciseInSQLite(exerciseList: List<Exercise>) {
        launch {
            val dao = RDatabase(getApplication()).exerciseDao()
            dao.deleteAllExercise()
            val uuidlist = dao.insertAll(*exerciseList.toTypedArray())
            var i = 0
            while (i < exerciseList.size) {
                exerciseList[i].uuid = uuidlist[i].toInt()
                i += 1
            }
            showExercises(exerciseList)
        }
        SharedPreferences.saveTimeExercise(System.nanoTime())
    }

    private fun storeRecipeInSQLite(recipeList: List<Recipe>) {
        launch {
            val dao = RDatabase(getApplication()).recipeDao()
            dao.deleteAllRecipe()
            val uuidList = dao.insertAll(*recipeList.toTypedArray())
            var i = 0
            while (i < recipeList.size) {
                recipeList[i].uuid = uuidList[i].toInt()
                i += 1
            }

            showRecipes(recipeList)
        }
        recipeSharedPreferences.saveTimeRecipe(System.nanoTime())
    }


    private fun getExerciseDataFromSQLite() {
        exerciseDownloading.value = true
        launch {
            val exerciseList = RDatabase(getApplication()).exerciseDao().getAllExercise()
            showExercises(exerciseList)
        }
    }

    private fun getRecipeDataFromSQLite() {
        recipeDownloading.value = true
        launch {
            val recipeList = RDatabase(getApplication()).recipeDao().getAllRecipe()
            showRecipes(recipeList)
        }
    }

    private fun showExercises(exerciseList: List<Exercise>) {
        exercises.value = exerciseList
        exerciseErrorMessage.value = false
        exerciseDownloading.value = false
    }

    private fun showRecipes(recipeList: List<Recipe>) {
        recipes.value = recipeList
        recipeErrorMessage.value = false
        recipeDownloading.value = false
    }
}