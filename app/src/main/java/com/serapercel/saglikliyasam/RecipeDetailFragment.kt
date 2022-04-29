package com.serapercel.saglikliyasam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.serapercel.saglikliyasam.databinding.FragmentRecipeDetailBinding
import androidx.navigation.fragment.navArgs as navArgs

class RecipeDetailFragment : Fragment() {

    private var _binding: FragmentRecipeDetailBinding? = null
    private val binding get() = _binding!!

    val args: RecipeDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipeDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        val recipeID = args.recipeIDExtra
        val recipe = recipeFromID(recipeID)
        if (recipe != null) {
            binding.cover.setImageResource(recipe.cover)
            binding.title.text = recipe.name
            binding.time.text = recipe.time
            binding.necessaries.text = recipe.necessaries
            binding.description.text = recipe.description
        }
        return view
    }

    private fun recipeFromID(recipeID: Int): Recipe? {
        for (recipe in recipeList) {
            if (recipe.id == recipeID)
                return recipe
        }
        return null
    }

}