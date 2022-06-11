package com.serapercel.saglikliyasam.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.serapercel.saglikliyasam.databinding.HomeExerciseCellBinding
import com.serapercel.saglikliyasam.model.Exercise
import com.serapercel.saglikliyasam.util.listener.ExerciseClickListener

class HomeExerciseCellAdapter(
    private val exercises: List<Exercise>,
    private val clickListener: ExerciseClickListener,
    private val context: Context
) : RecyclerView.Adapter<HomeExerciseCellHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeExerciseCellHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = HomeExerciseCellBinding.inflate(from, parent, false)
        return HomeExerciseCellHolder(binding, clickListener, context)
    }

    override fun onBindViewHolder(holder: HomeExerciseCellHolder, position: Int) {
        holder.bindExercise(exercises[position])
    }

    override fun getItemCount(): Int = exercises.size

}