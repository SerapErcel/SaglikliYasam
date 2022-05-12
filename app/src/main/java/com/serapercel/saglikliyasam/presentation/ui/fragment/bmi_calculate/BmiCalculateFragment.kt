package com.serapercel.saglikliyasam.presentation.ui.fragment.bmi_calculate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.serapercel.saglikliyasam.databinding.FragmentBmiCalculateBinding
import com.serapercel.saglikliyasam.model.BMI
import com.serapercel.saglikliyasam.presentation.ui.fragment.login.LoginViewModel


class BmiCalculateFragment : Fragment() {

    private var _binding: FragmentBmiCalculateBinding? = null
    private val binding get() = _binding!!
    private lateinit var bmiList: List<BMI>
    private lateinit var lastBmi: BMI
    private lateinit var viewModel: BmiCalculateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBmiCalculateBinding.inflate(inflater, container, false)
        binding.bmiLayout.isVisible = false
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[BmiCalculateViewModel::class.java]

        binding.calculateButton.setOnClickListener {
            binding.bmiLayout.isVisible = true
            results()
        }
    }

    private fun results() {
        bmiList = viewModel.calculate(
            binding.editTextHeight.text.toString(),
            binding.editTextWeight.text.toString()
        )
        lastBmi = bmiList[bmiList.size - 1]
        binding.bmiResult.text = lastBmi.result.toString()
        binding.result.text = lastBmi.name
        binding.bmiDescription.text = lastBmi.description
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}