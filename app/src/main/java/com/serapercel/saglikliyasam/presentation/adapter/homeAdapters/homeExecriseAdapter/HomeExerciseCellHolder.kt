package com.serapercel.saglikliyasam.presentation.adapter.homeAdapters.homeExecriseAdapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.serapercel.saglikliyasam.databinding.HomeExerciseCellBinding
import com.serapercel.saglikliyasam.model.Exercise
import com.serapercel.saglikliyasam.util.downloadImage
import com.serapercel.saglikliyasam.util.listener.ExerciseClickListener
import com.serapercel.saglikliyasam.util.placeHolder

class HomeExerciseCellHolder(
    private val homeExerciseCellBinding: HomeExerciseCellBinding,
    private val clickListener: ExerciseClickListener,
    private val context: Context

) : RecyclerView.ViewHolder(homeExerciseCellBinding.root) {

    fun bindExercise(exercise: Exercise) {
        homeExerciseCellBinding.exerciseCover.downloadImage(
            exercise.exerciseImage,
            placeHolder(context)
        )
        homeExerciseCellBinding.title.text = exercise.name

        homeExerciseCellBinding.exerciseCell.setOnClickListener {
            clickListener.onClick(exercise)
        }
    }

}