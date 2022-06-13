package com.serapercel.saglikliyasam.presentation.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.serapercel.saglikliyasam.R
import com.serapercel.saglikliyasam.databinding.FragmentHomeBinding
import com.serapercel.saglikliyasam.model.Exercise
import com.serapercel.saglikliyasam.model.Recipe
import com.serapercel.saglikliyasam.presentation.adapter.homeAdapters.homeExecriseAdapter.HomeExerciseCellAdapter
import com.serapercel.saglikliyasam.presentation.adapter.homeAdapters.homeRecipeAdapter.HomeRecipeCellAdapter
import com.serapercel.saglikliyasam.util.listener.ExerciseClickListener
import com.serapercel.saglikliyasam.util.listener.RecipeClickListener

var recipeList = mutableListOf<Recipe>()

class HomeFragment : Fragment(), ExerciseClickListener, RecipeClickListener {

    private lateinit var viewModel: HomeViewModel

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        binding.drinkWaterButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_waterDrinkingFragment)
        }
        binding.drinkWaterTextButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_waterDrinkingFragment)
        }
        binding.medicinesButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_medicinesFragment)
        }
        binding.medicinesTextButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_medicinesFragment)
        }
        binding.mealButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_mealsFragment)
        }
        binding.mealTextButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_mealsFragment)
        }

        viewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        viewModel.refreshData()


        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.exercises.observe(viewLifecycleOwner) { exerciseList ->
            exerciseList?.let {
                updateRecyclerExerciseList(exerciseList)
            }
        }
        viewModel.exerciseErrorMessage.observe(viewLifecycleOwner) { error ->
            error?.let {
                if (it) {
                    binding.homeExerciseRecyclerView.visibility = View.GONE
                } else {
                    binding.homeExerciseRecyclerView.visibility = View.VISIBLE
                }
            }
        }
        viewModel.exerciseDownloading.observe(viewLifecycleOwner) { uploading ->
            uploading?.let {
                if (it) {
                    binding.homeExerciseRecyclerView.visibility = View.GONE
                } else {
                    binding.homeExerciseRecyclerView.visibility = View.VISIBLE

                }
            }
        }
        viewModel.recipes.observe(viewLifecycleOwner) { recipeList ->
            recipeList?.let {
                updateRecyclerRecipeList(recipeList)
            }
        }
        viewModel.recipeErrorMessage.observe(viewLifecycleOwner) { error ->
            error?.let {
                if (it) {
                    binding.homeRecipesRecyclerView.visibility = View.GONE
                } else {
                    binding.homeRecipesRecyclerView.visibility = View.VISIBLE
                }
            }
        }
        viewModel.recipeDownloading.observe(viewLifecycleOwner) { uploading ->
            uploading?.let {
                if (it) {
                    binding.homeRecipesRecyclerView.visibility = View.GONE
                } else {
                    binding.homeRecipesRecyclerView.visibility = View.VISIBLE

                }
            }
        }
    }

    private fun updateRecyclerExerciseList(exerciseList: List<Exercise>) {
        binding.homeExerciseRecyclerView.visibility = View.VISIBLE
        binding.homeExerciseRecyclerView.adapter =
            HomeExerciseCellAdapter(exerciseList, this, requireContext())
    }

    private fun updateRecyclerRecipeList(recipeList: List<Recipe>) {
        binding.homeRecipesRecyclerView.visibility = View.VISIBLE
        binding.homeRecipesRecyclerView.adapter =
            HomeRecipeCellAdapter(recipeList, this, requireContext())
    }

    private fun initView() {

        binding.homeExerciseRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = HomeExerciseCellAdapter(emptyList(), this@HomeFragment, requireContext())
        }
        binding.homeRecipesRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 1)
            adapter = HomeRecipeCellAdapter(emptyList(), this@HomeFragment, requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onClick(exercise: Exercise) {
        val action = HomeFragmentDirections.actionHomeFragmentToExerciseDetailFragment(
            exercise.uuid
        )
        findNavController().navigate(action)
    }

    override fun onClick(recipe: Recipe) {
        val action = HomeFragmentDirections.actionHomeFragmentToRecipeDetailFragment(
            recipe.uuid
        )
        findNavController().navigate(action)
    }

}