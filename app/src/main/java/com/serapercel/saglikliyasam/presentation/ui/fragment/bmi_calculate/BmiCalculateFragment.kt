package com.serapercel.saglikliyasam.presentation.ui.fragment.bmi_calculate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.serapercel.saglikliyasam.databinding.FragmentBmiCalculateBinding


class BmiCalculateFragment : Fragment() {
    private var _binding: FragmentBmiCalculateBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBmiCalculateBinding.inflate(inflater, container, false)
        binding.bmiLayout.isVisible = false
        binding.calculateButton.setOnClickListener {
            binding.bmiLayout.isVisible = true
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}