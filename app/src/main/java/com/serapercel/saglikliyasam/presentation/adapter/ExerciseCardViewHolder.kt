package com.serapercel.saglikliyasam.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.serapercel.saglikliyasam.databinding.ExerciseCardCellBinding
import com.serapercel.saglikliyasam.model.Exercise
import com.serapercel.saglikliyasam.util.listener.ExerciseClickListener

class ExerciseCardViewHolder(
    private val exerciseCardCellBinding: ExerciseCardCellBinding,
    private val clickListener: ExerciseClickListener
) : RecyclerView.ViewHolder(exerciseCardCellBinding.root) {

    fun bindExercise(exercise: Exercise) {
        exerciseCardCellBinding.exerciseCover.setImageResource(exercise.cover)
        exerciseCardCellBinding.title.text = exercise.name
        exerciseCardCellBinding.time.text = exercise.time

        exerciseCardCellBinding.exerciseCardView.setOnClickListener {
            clickListener.onClick(exercise)
        }
    }

}