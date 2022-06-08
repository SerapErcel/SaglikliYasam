package com.serapercel.saglikliyasam.presentation.ui.fragment.recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.serapercel.saglikliyasam.databinding.FragmentRecipesBinding
import com.serapercel.saglikliyasam.model.Recipe
import com.serapercel.saglikliyasam.presentation.adapter.RecipeCardAdapter
import com.serapercel.saglikliyasam.util.listener.RecipeClickListener

class RecipesFragment : Fragment(), RecipeClickListener {

    private lateinit var viewModel: RecipesViewModel

    private var _binding: FragmentRecipesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(RecipesViewModel::class.java)
        viewModel.refreshData()


        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = RecipeCardAdapter(emptyList(), this@RecipesFragment, requireContext())

        }

        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.recipes.observe(viewLifecycleOwner) { recipeList ->
            recipeList?.let {
                updateRecyclerList(recipeList)
            }
        }
        viewModel.recipeErrorMessage.observe(viewLifecycleOwner) { error ->
            error?.let {
                if (it) {
                    binding.recipeListError.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                } else {
                    binding.recipeListError.visibility = View.GONE
                    binding.recyclerView.visibility = View.VISIBLE
                }
            }
        }
        viewModel.recipeDownloading.observe(viewLifecycleOwner) { uploading ->
            uploading?.let {
                if (it) {
                    binding.recyclerView.visibility = View.GONE
                    binding.recipeListError.visibility = View.GONE
                    binding.recipeListProgress.visibility = View.VISIBLE
                } else {
                    binding.recipeListProgress.visibility = View.GONE
                    binding.recyclerView.visibility = View.VISIBLE

                }
            }
        }
    }

    private fun updateRecyclerList(recipeList: List<Recipe>) {
        binding.recyclerView.visibility = View.VISIBLE
        binding.recyclerView.adapter =
            RecipeCardAdapter(recipeList, this, requireContext())
    }

    override fun onClick(recipe: Recipe) {
        val action =
            RecipesFragmentDirections.actionRecipesFragmentToRecipeDetailFragment(recipe.uuid)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}