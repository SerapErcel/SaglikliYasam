package com.serapercel.saglikliyasam.presentation.ui.fragment.exercises

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.serapercel.saglikliyasam.R
import com.serapercel.saglikliyasam.databinding.FragmentExercisesBinding
import com.serapercel.saglikliyasam.model.Exercise
import com.serapercel.saglikliyasam.model.exerciseList
import com.serapercel.saglikliyasam.presentation.adapter.ExerciseCardAdapter
import com.serapercel.saglikliyasam.util.ExerciseClickListener

class ExercisesFragment : Fragment(), ExerciseClickListener {

    private var _binding: FragmentExercisesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExercisesBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        populateExercises()

        binding.exerciseRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 1)
            adapter = ExerciseCardAdapter(exerciseList, this@ExercisesFragment)
        }
    }

    override fun onClick(exercise: Exercise) {
        val action = ExercisesFragmentDirections.actionExercisesFragmentToExerciseDetailFragment(
            exercise.id!!
        )
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // todo "change mock data with real data"
    private fun populateExercises() {
        val exercise1 = Exercise(
            R.drawable.exercise,
            name = "Isınma Egzersizi",
            time = "3 dakika",
            description = "Isınma egzersizini verilen süre boyunca bulunduğunuz yerde tekrar tekar uygulayınız. "
        )
        exerciseList.add(exercise1)
        exerciseList.add(exercise1)
        exerciseList.add(exercise1)
        exerciseList.add(exercise1)
        exerciseList.add(exercise1)
        exerciseList.add(exercise1)
    }
}




