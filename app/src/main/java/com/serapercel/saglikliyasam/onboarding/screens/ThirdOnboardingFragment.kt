package com.serapercel.saglikliyasam.onboarding.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.serapercel.saglikliyasam.R
import com.serapercel.saglikliyasam.databinding.FragmentFirstOnboardingBinding
import com.serapercel.saglikliyasam.databinding.FragmentThirdOnboardingBinding

class ThirdOnboardingFragment : Fragment() {

    private var _binding: FragmentThirdOnboardingBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdOnboardingBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.FinishButton.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_loginFragment)
            onBoardingFinished()
        }
        return view
    }

    private fun onBoardingFinished() {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }

}