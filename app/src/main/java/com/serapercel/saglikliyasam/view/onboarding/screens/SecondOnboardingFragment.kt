package com.serapercel.saglikliyasam.view.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.serapercel.saglikliyasam.R
import com.serapercel.saglikliyasam.databinding.FragmentFirstOnboardingBinding
import com.serapercel.saglikliyasam.databinding.FragmentSecondOnboardingBinding
import com.serapercel.saglikliyasam.databinding.FragmentThirdOnboardingBinding

class SecondOnboardingFragment : Fragment() {

    private var _binding: FragmentSecondOnboardingBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondOnboardingBinding.inflate(inflater, container, false)
        val view = binding.root
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        binding.ContinueButton.setOnClickListener{
            viewPager?.currentItem = 2
        }
        return view
    }

}