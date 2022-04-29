package com.serapercel.saglikliyasam.presentation.ui.fragment.exercises

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.serapercel.saglikliyasam.R
import com.serapercel.saglikliyasam.databinding.FragmentExercisesBinding
import com.serapercel.saglikliyasam.model.Exercise
import com.serapercel.saglikliyasam.model.exerciseList

class ExercisesFragment : Fragment() {

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

        /*
             populateExercises()

            binding.exerciseRecyclerView.apply {
             layoutManager = GridLayoutManager(context, 1)
             adapter = ExerciseCardAdapter(exerciseList, )
         }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /*
    override fun onClick(exercsie: Exercise) {
        val action =
            ExercisesFragmentDirections.actionRecipesFragmentToRecipeDetailFragment(exercsie.id!!)
        view?.let { Navigation.findNavController(it).navigate(action) }

     */

}


