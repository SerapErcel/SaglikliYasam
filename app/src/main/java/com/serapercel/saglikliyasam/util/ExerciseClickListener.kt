package com.serapercel.saglikliyasam.util

import com.serapercel.saglikliyasam.model.Exercise

interface ExerciseClickListener {
    fun onClick(exercise: Exercise)
}