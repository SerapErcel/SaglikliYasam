package com.serapercel.saglikliyasam.presentation.ui.fragment.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.serapercel.saglikliyasam.R
import com.serapercel.saglikliyasam.databinding.FragmentSplashBinding
import com.serapercel.saglikliyasam.presentation.ui.activity.FlowActivity
import com.serapercel.saglikliyasam.util.Constant.SPLASH_TIME

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        val view = binding.root
        Handler(Looper.myLooper()!!).postDelayed({
            if (onBoardingFinished()) {
                if (auth.currentUser != null) {
                    val intent = Intent(requireActivity(), FlowActivity::class.java)
                    requireActivity().startActivity(intent)
                    requireActivity().finish()
                } else {
                    findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
                }
            } else {
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
            }
        }, SPLASH_TIME)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onBoardingFinished(): Boolean{
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished",false)
    }

}