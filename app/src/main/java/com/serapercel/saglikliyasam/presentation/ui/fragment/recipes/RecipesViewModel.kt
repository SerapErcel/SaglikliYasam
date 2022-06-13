package com.serapercel.saglikliyasam.presentation.ui.fragment.recipes

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.serapercel.saglikliyasam.database.RDatabase
import com.serapercel.saglikliyasam.database.SharedPreferences
import com.serapercel.saglikliyasam.model.Recipe
import com.serapercel.saglikliyasam.service.recipeService.RecipeAPIService
import com.serapercel.saglikliyasam.util.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class RecipesViewModel(application: Application) : BaseViewModel(application) {

    val recipes = MutableLiveData<List<Recipe>>()
    val recipeErrorMessage = MutableLiveData<Boolean>()
    val recipeDownloading = MutableLiveData<Boolean>()

    private var updateTime = 10 * 60 * 1000 * 1000 * 1000L
    private val recipeAPIService = RecipeAPIService()
    private val disposable = CompositeDisposable()
    private val recipeSharedPreferences = SharedPreferences(getApplication())

    fun refreshData() {
        val saveTime = recipeSharedPreferences.getTimeRecipe()
        if (saveTime != null && saveTime != 0L && System.nanoTime() - saveTime < updateTime) {
            getDataFromSQLite()

        } else {
            getDataFromInternet()
        }
    }

    fun refreshFromInternet() {
        getDataFromInternet()
    }

    private fun getDataFromSQLite() {
        recipeDownloading.value = true
        launch {
            val recipeList = RDatabase(getApplication()).recipeDao().getAllRecipe()
            showRecipes(recipeList)
        }
    }

    private fun getDataFromInternet() {
        recipeDownloading.value = true
        disposable.add(
            recipeAPIService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Recipe>>() {
                    override fun onSuccess(t: List<Recipe>) {
                        storeInSQLite(t)
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

    private fun showRecipes(recipeList: List<Recipe>) {
        recipes.value = recipeList
        recipeErrorMessage.value = false
        recipeDownloading.value = false
    }

    private fun storeInSQLite(recipeList: List<Recipe>) {
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

}