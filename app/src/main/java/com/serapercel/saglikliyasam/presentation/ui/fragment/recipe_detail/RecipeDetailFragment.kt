package com.serapercel.saglikliyasam.presentation.ui.fragment.recipe_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.serapercel.saglikliyasam.databinding.FragmentRecipeDetailBinding
import com.serapercel.saglikliyasam.model.Recipe
import com.serapercel.saglikliyasam.model.recipeList
import androidx.navigation.fragment.navArgs as navArgs

class RecipeDetailFragment : Fragment() {

    private var _binding: FragmentRecipeDetailBinding? = null
    private val binding get() = _binding!!

    private val args: RecipeDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipeDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        val recipeID = args.recipeIDExtra
        val recipe = recipeFromID(recipeID)
        if (recipe != null) {
            binding.apply {
                cover.setImageResource(recipe.cover)
                title.text = recipe.name
                time.text = recipe.time
                necessaries.text = recipe.necessaries
                description.text = recipe.description
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        val recipeID = args.recipeIDExtra
        val recipe = recipeFromID(recipeID)
        if (recipe != null) {
            binding.apply {
                cover.setImageResource(recipe.cover)
                title.text = recipe.name
                time.text = recipe.time
                necessaries.text = recipe.necessaries
                description.text = recipe.description
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun recipeFromID(recipeID: Int): Recipe? {
        for (recipe in recipeList) {
            if (recipe.id == recipeID)
                return recipe
        }
        return null
    }

}