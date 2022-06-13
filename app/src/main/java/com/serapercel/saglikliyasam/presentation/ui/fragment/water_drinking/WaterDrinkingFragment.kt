package com.serapercel.saglikliyasam.presentation.ui.fragment.water_drinking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.serapercel.saglikliyasam.R
import com.serapercel.saglikliyasam.database.SharedPreferences
import com.serapercel.saglikliyasam.databinding.FragmentWaterDrinkingBinding

class WaterDrinkingFragment : Fragment() {

    private var _binding: FragmentWaterDrinkingBinding? = null
    private val binding get() = _binding!!

    private val sharedPreferences = SharedPreferences()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWaterDrinkingBinding.inflate(inflater, container, false)
        setGlassImage()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.amount.text = sharedPreferences.getWater().toString()
        var waterNum = sharedPreferences.getWater()!!

        binding.positiveFab.setOnClickListener {
            waterNum++
            sharedPreferences.addWater(waterNum)
            setGlassImage()
            binding.amount.text = sharedPreferences.getWater().toString()

        }
        binding.negativeFab.setOnClickListener {
            if (waterNum > 0) {
                waterNum--
                sharedPreferences.addWater(waterNum)
                setGlassImage()
                binding.amount.text = sharedPreferences.getWater().toString()
            }
        }
    }

    private fun setGlassImage() = when (sharedPreferences.getWater()) {
        0 -> binding.glass.setImageResource(R.drawable.glass)
        1 -> binding.glass.setImageResource(R.drawable.glass2)
        2 -> binding.glass.setImageResource(R.drawable.glass3)
        3 -> binding.glass.setImageResource(R.drawable.glass4)
        4 -> binding.glass.setImageResource(R.drawable.glass5)
        else -> {
            binding.glass.setImageResource(R.drawable.glass5)
        }
    }
}