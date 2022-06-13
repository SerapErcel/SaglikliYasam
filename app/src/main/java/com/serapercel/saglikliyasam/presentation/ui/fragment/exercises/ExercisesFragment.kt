package com.serapercel.saglikliyasam.presentation.ui.fragment.exercises

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.serapercel.saglikliyasam.databinding.FragmentExercisesBinding
import com.serapercel.saglikliyasam.model.Exercise
import com.serapercel.saglikliyasam.presentation.adapter.exerciseCardAdapter.ExerciseCardAdapter
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
        viewModel.exercises.observe(viewLifecycleOwner) { exerciseList ->
            exerciseList?.let {
                updateRecyclerList(exerciseList)
            }
        }
        viewModel.exerciseErrorMessage.observe(viewLifecycleOwner) { error ->
            error?.let {
                if (it) {
                    binding.exerciseRecyclerView.visibility = View.GONE
                    binding.exerciseListError.visibility = View.VISIBLE
                } else {
                    binding.exerciseListError.visibility = View.GONE
                    binding.exerciseRecyclerView.visibility = View.VISIBLE
                }
            }
        }
        viewModel.exerciseDownloading.observe(viewLifecycleOwner) { uploading ->
            uploading?.let {
                if (it) {
                    binding.exerciseRecyclerView.visibility = View.GONE
                    binding.exerciseListError.visibility = View.GONE
                    binding.exerciseListProgress.visibility = View.VISIBLE
                } else {
                    binding.exerciseListProgress.visibility = View.GONE
                    binding.exerciseRecyclerView.visibility = View.VISIBLE

                }
            }
        }
    }

    private fun updateRecyclerList(exerciseList: List<Exercise>) {
        binding.exerciseRecyclerView.visibility = View.VISIBLE
        binding.exerciseRecyclerView.adapter =
            ExerciseCardAdapter(exerciseList, this, requireContext())
    }

    override fun onClick(exercise: Exercise) {
        val action = ExercisesFragmentDirections.actionExercisesFragmentToExerciseDetailFragment(
            exercise.uuid
        )
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}




