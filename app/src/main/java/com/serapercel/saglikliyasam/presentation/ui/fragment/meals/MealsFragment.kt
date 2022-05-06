package com.serapercel.saglikliyasam.presentation.ui.fragment.meals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.serapercel.saglikliyasam.R
import com.serapercel.saglikliyasam.databinding.FragmentMealsBinding
import com.serapercel.saglikliyasam.model.Meal
import com.serapercel.saglikliyasam.model.Medicine
import com.serapercel.saglikliyasam.model.mealList
import com.serapercel.saglikliyasam.model.medicineList
import com.serapercel.saglikliyasam.presentation.adapter.MealAdapter

class MealsFragment : Fragment() {

    private var _binding: FragmentMealsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMealsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        populateMeal()
        binding.mealsRecyclerView.layoutManager = LinearLayoutManager(context)
        val mealAdapter = MealAdapter()
        binding.mealsRecyclerView.adapter = mealAdapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // todo "change mock data with real data"
    private fun populateMeal() {
        val meal1 = Meal(
            name = "Kahvaltı",
            time = "08:00"
        )
        mealList.add(meal1)
        mealList.add(meal1)
        mealList.add(meal1)
        mealList.add(meal1)
        mealList.add(meal1)
        mealList.add(meal1)

    }

}