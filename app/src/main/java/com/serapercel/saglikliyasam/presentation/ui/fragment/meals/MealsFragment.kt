package com.serapercel.saglikliyasam.presentation.ui.fragment.meals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.serapercel.saglikliyasam.R
import com.serapercel.saglikliyasam.databinding.FragmentMealsBinding
import com.serapercel.saglikliyasam.model.Meal
import com.serapercel.saglikliyasam.presentation.adapter.MealAdapter
import com.serapercel.saglikliyasam.presentation.adapter.MedicineAdapter

class MealsFragment : Fragment() {

    private lateinit var viewModel: MealsViewModel

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

        viewModel = ViewModelProvider(requireActivity()).get(MealsViewModel::class.java)
        viewModel.getDataFromSQLite()

        binding.mealsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MedicineAdapter(emptyList())
        }

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_mealsFragment_to_addMealFragment)
        }

        observeLiveData()

    }

    private fun observeLiveData() {
        viewModel.meals.observe(viewLifecycleOwner) { mealList ->
            mealList?.let {
                updateRecyclerList(mealList)
            }
        }
    }

    private fun updateRecyclerList(mealList: List<Meal>) {
        binding.mealsRecyclerView.adapter =
            MealAdapter(mealList)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}