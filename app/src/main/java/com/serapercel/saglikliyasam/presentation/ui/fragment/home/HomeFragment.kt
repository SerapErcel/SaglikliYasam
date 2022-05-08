package com.serapercel.saglikliyasam.presentation.ui.fragment.home

import android.os.Bundle
import android.util.LayoutDirection
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.serapercel.saglikliyasam.R
import com.serapercel.saglikliyasam.databinding.FragmentHomeBinding
import com.serapercel.saglikliyasam.model.Exercise
import com.serapercel.saglikliyasam.model.Recipe
import com.serapercel.saglikliyasam.model.exerciseList
import com.serapercel.saglikliyasam.model.recipeList
import com.serapercel.saglikliyasam.presentation.adapter.CardAdapter
import com.serapercel.saglikliyasam.presentation.adapter.ExerciseCardAdapter
import com.serapercel.saglikliyasam.presentation.adapter.HomeExerciseCellAdapter
import com.serapercel.saglikliyasam.presentation.adapter.HomeRecipeCellAdapter
import com.serapercel.saglikliyasam.presentation.ui.fragment.exercises.ExercisesFragmentDirections
import com.serapercel.saglikliyasam.util.ExerciseClickListener
import com.serapercel.saglikliyasam.util.RecipeClickListener

class HomeFragment : Fragment(), ExerciseClickListener, RecipeClickListener {

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
    }

    private fun initView() {
        populateExercises()
        populateRecipes()

        binding.homeExerciseRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter =
                HomeExerciseCellAdapter(exerciseList, this@HomeFragment)
        }
        binding.homeRecpiesRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 1)
            adapter = HomeRecipeCellAdapter(recipeList, this@HomeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // todo "change mock data with real data"
    private fun populateExercises() {
        val exercise1 = Exercise(
            R.drawable.exercise,
            name = "Isınma Egzersizi",
            time = "3 dakika",
            description = "Isınma egzersizini verilen süre boyunca bulunduğunuz yerde tekrar tekar uygulayınız. "
        )
        exerciseList.add(exercise1)
        exerciseList.add(exercise1)
        exerciseList.add(exercise1)
        exerciseList.add(exercise1)
        exerciseList.add(exercise1)
        exerciseList.add(exercise1)
    }

    // todo "change mock data with real data"
    private fun populateRecipes() {
        val recipe1 = Recipe(
            R.drawable.patlican_pizza,
            name = "Patlıcan Pizza",
            time = "40 dakika",
            necessaries = "2 adet patlıcan 3 adet domates 1 yemek kaşığı salça 1 dilim sucuk 1 çay bardağı haşlanmış mısır",
            description = "patlıcanları uzun uzun dilimle, tepsinin altına diz, üzerine salçalı sos yay, mantar domates sucuk vb. malzmeleri diz fırına at en son üzerine kaşar peyniri rendele ve afiyet olsun."
        )
        recipeList.add(recipe1)
        recipeList.add(recipe1)
        recipeList.add(recipe1)
        recipeList.add(recipe1)
        recipeList.add(recipe1)
        recipeList.add(recipe1)

    }

    override fun onClick(exercise: Exercise) {
        val action = HomeFragmentDirections.actionHomeFragmentToExerciseDetailFragment(
            exercise.id!!
        )
        findNavController().navigate(action)
    }

    override fun onClick(recipe: Recipe) {
        val action = HomeFragmentDirections.actionHomeFragmentToRecipeDetailFragment(
            recipe.id!!
        )
        findNavController().navigate(action)
    }

}