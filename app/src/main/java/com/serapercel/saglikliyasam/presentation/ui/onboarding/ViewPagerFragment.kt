package com.serapercel.saglikliyasam.presentation.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.serapercel.saglikliyasam.databinding.FragmentViewPagerBinding
import com.serapercel.saglikliyasam.presentation.adapter.ViewPagerAdapter
import com.serapercel.saglikliyasam.presentation.ui.onboarding.screens.FirstOnboardingFragment
import com.serapercel.saglikliyasam.presentation.ui.onboarding.screens.SecondOnboardingFragment
import com.serapercel.saglikliyasam.presentation.ui.onboarding.screens.ThirdOnboardingFragment

class ViewPagerFragment : Fragment() {

    private var _binding: FragmentViewPagerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        val fragmentList = arrayListOf<Fragment>(
            FirstOnboardingFragment(),
            SecondOnboardingFragment(),
            ThirdOnboardingFragment()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        binding.viewPager.adapter = adapter
    }
}