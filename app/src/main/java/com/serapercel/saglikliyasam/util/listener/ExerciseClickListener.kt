package com.serapercel.saglikliyasam.util.listener

import com.serapercel.saglikliyasam.model.Exercise

interface ExerciseClickListener {
    fun onClick(exercise: Exercise)
}