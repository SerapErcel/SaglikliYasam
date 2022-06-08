package com.serapercel.saglikliyasam.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.serapercel.saglikliyasam.databinding.HomeExerciseCellBinding
import com.serapercel.saglikliyasam.model.Exercise
import com.serapercel.saglikliyasam.util.listener.ExerciseClickListener

class HomeExerciseCellHolder(
    private val homeExerciseCellBinding: HomeExerciseCellBinding,
    private val clickListener: ExerciseClickListener
) : RecyclerView.ViewHolder(homeExerciseCellBinding.root) {

    fun bindExercise(exercise: Exercise) {
        homeExerciseCellBinding.exerciseCover.setImageResource(exercise.cover)
        homeExerciseCellBinding.title.text = exercise.name
        homeExerciseCellBinding.time.text = exercise.time

        homeExerciseCellBinding.exerciseCell.setOnClickListener {
            clickListener.onClick(exercise)
        }
    }

}