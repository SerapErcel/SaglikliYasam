package com.serapercel.saglikliyasam.presentation.ui.fragment.exercise_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.serapercel.saglikliyasam.databinding.FragmentExerciseDetailBinding
import com.serapercel.saglikliyasam.model.Exercise

class ExerciseDetailFragment : Fragment() {

    private var _binding: FragmentExerciseDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var exerciseId: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExerciseDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initUi()
        initClickListener()
    }

    private fun initView() {
        //exerciseId = ""
    }

    private fun initUi() {
        //val x = exerciseId
    }

    private fun initClickListener() {
        /*binding.apply {
            buttonX.setOnClickListener {

            }
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

/*
// Argumanli gonderirken
    val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment(gidecek argument)
    findNavController().navigate(action)

// argument siz
    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)

 */