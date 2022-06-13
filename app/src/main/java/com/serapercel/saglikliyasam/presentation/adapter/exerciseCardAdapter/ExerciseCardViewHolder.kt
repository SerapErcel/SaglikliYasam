package com.serapercel.saglikliyasam.presentation.adapter.exerciseCardAdapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.serapercel.saglikliyasam.databinding.ExerciseCardCellBinding
import com.serapercel.saglikliyasam.model.Exercise
import com.serapercel.saglikliyasam.util.downloadImage
import com.serapercel.saglikliyasam.util.listener.ExerciseClickListener
import com.serapercel.saglikliyasam.util.placeHolder

class ExerciseCardViewHolder(
    private val exerciseCardCellBinding: ExerciseCardCellBinding,
    private val clickListener: ExerciseClickListener,
    private val context: Context
) : RecyclerView.ViewHolder(exerciseCardCellBinding.root) {

    fun bindExercise(exercise: Exercise) {
        exerciseCardCellBinding.exerciseCover.downloadImage(
            exercise.exerciseImage,
            placeHolder(context)
        )
        exerciseCardCellBinding.title.text = exercise.name
        exerciseCardCellBinding.time.text = exercise.repeat

        exerciseCardCellBinding.exerciseCardView.setOnClickListener {
            clickListener.onClick(exercise)
        }
    }

}