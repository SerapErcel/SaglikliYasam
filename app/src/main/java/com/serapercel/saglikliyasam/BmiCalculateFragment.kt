package com.serapercel.saglikliyasam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.serapercel.saglikliyasam.databinding.FragmentBmiCalculateBinding

class BmiCalculateFragment : Fragment() {
    private var _binding: FragmentBmiCalculateBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentBmiCalculateBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

}