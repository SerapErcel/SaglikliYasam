package com.serapercel.saglikliyasam.presentation.ui.fragment.medicines

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.serapercel.saglikliyasam.R
import com.serapercel.saglikliyasam.databinding.FragmentMedicinesBinding
import com.serapercel.saglikliyasam.model.Medicine
import com.serapercel.saglikliyasam.presentation.adapter.MedicineAdapter

class MedicinesFragment : Fragment() {

    private lateinit var viewModel: MedicinesViewModel

    private var _binding: FragmentMedicinesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMedicinesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(MedicinesViewModel::class.java)
        viewModel.getDataFromSQLite()

        binding.medicinesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MedicineAdapter(emptyList())
        }

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_medicinesFragment_to_medicineAddFragment)
        }

        observeLiveData()

    }

    private fun observeLiveData() {
        viewModel.medicines.observe(viewLifecycleOwner) { medicineList ->
            medicineList?.let {
                updateRecyclerList(medicineList)
            }
        }
    }

    private fun updateRecyclerList(medicineList: List<Medicine>) {
        binding.medicinesRecyclerView.adapter =
            MedicineAdapter(medicineList)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}