package com.serapercel.saglikliyasam.presentation.ui.fragment.exercises

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.serapercel.saglikliyasam.databinding.FragmentExercisesBinding
import com.serapercel.saglikliyasam.model.Exercise
import com.serapercel.saglikliyasam.presentation.adapter.ExerciseCardAdapter
import com.serapercel.saglikliyasam.util.listener.ExerciseClickListener

class ExercisesFragment : Fragment(), ExerciseClickListener {

    private lateinit var viewModel: ExercisesViewModel

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

        viewModel = ViewModelProvider(requireActivity()).get(ExercisesViewModel::class.java)
        viewModel.refreshData()

        binding.exerciseRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 1)
            adapter = ExerciseCardAdapter(emptyList(), this@ExercisesFragment, requireContext())
        }
        observeLiveData()
    }

    private fun observeLiveData() {
        TODO("Not yet implemented")
    }

    override fun onClick(exercise: Exercise) {
        val action = ExercisesFragmentDirections.actionExercisesFragmentToExerciseDetailFragment(
            exercise.uuid!!
        )
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}




