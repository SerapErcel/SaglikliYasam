package com.serapercel.saglikliyasam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.serapercel.saglikliyasam.databinding.FragmentRecipesBinding


class RecipesFragment : Fragment(), RecipeClickListener {

    private var _binding: FragmentRecipesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        populateRecipes()
        _binding = FragmentRecipesBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = CardAdapter(recipeList, this@RecipesFragment)
        }

        return view
    }

    override fun onClick(recipe: Recipe) {
        val action =
            RecipesFragmentDirections.actionRecipesFragmentToRecipeDetailFragment(recipe.id!!)
        view?.let { Navigation.findNavController(it).navigate(action) }

    }

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

}