package com.serapercel.saglikliyasam.presentation.ui.fragment.recipe_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.serapercel.saglikliyasam.databinding.FragmentRecipeDetailBinding
import com.serapercel.saglikliyasam.util.downloadImage
import com.serapercel.saglikliyasam.util.placeHolder
import androidx.navigation.fragment.navArgs as navArgs

class RecipeDetailFragment : Fragment() {

    private lateinit var viewModel: RecipeDetailViewModel
    private var recipeID = 0

    private var _binding: FragmentRecipeDetailBinding? = null
    private val binding get() = _binding!!

    private val args: RecipeDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipeID = args.recipeID

        viewModel = ViewModelProviders.of(this).get(RecipeDetailViewModel::class.java)
        viewModel.getRecipeFromRoom(recipeID)

        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.recipeLiveData.observe(viewLifecycleOwner) { recipe ->
            recipe?.let {
                binding.title.text = recipe.name
                binding.time.text = recipe.time
                binding.necessaries.text = recipe.necessaries
                binding.description.text = recipe.description
                context?.let {
                    binding.cover.downloadImage(recipe.recipeImage, placeHolder(requireContext()))
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}