package com.serapercel.saglikliyasam.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.serapercel.saglikliyasam.databinding.ExerciseCardCellBinding
import com.serapercel.saglikliyasam.model.Exercise
import com.serapercel.saglikliyasam.util.listener.ExerciseClickListener

class ExerciseCardAdapter(
    private val exercises: List<Exercise>,
    private val clickListener: ExerciseClickListener
) : RecyclerView.Adapter<ExerciseCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseCardViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = ExerciseCardCellBinding.inflate(from, parent, false)
        return ExerciseCardViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: ExerciseCardViewHolder, position: Int) {
        holder.bindExercise(exercises[position])
    }

    override fun getItemCount(): Int = exercises.size

}