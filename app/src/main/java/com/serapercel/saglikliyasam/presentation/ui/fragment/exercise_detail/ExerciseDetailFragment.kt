package com.serapercel.saglikliyasam.presentation.ui.fragment.exercise_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.serapercel.saglikliyasam.databinding.FragmentExerciseDetailBinding
import com.serapercel.saglikliyasam.util.downloadImage
import com.serapercel.saglikliyasam.util.placeHolder

class ExerciseDetailFragment : Fragment() {

    private lateinit var viewModel: ExerciseDetailViewModel
    private var exerciseID = 0

    private var _binding: FragmentExerciseDetailBinding? = null
    private val binding get() = _binding!!

    private val args: ExerciseDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExerciseDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        exerciseID = args.exerciseID

        viewModel = ViewModelProviders.of(this).get(ExerciseDetailViewModel::class.java)
        viewModel.getExerciseFromRoom(exerciseID)

        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.exerciseLiveData.observe(viewLifecycleOwner) { exercise ->
            exercise?.let {
                binding.exerciseTitle.text = exercise.name
                binding.exerciseTime.text = exercise.repeat
                binding.exerciseDescription.text = exercise.description
                binding.exercise.text = exercise.exercise
                context?.let {
                    binding.exerciseCover.downloadImage(
                        exercise.exerciseImage,
                        placeHolder(requireContext())
                    )
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
