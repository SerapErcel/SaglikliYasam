package com.serapercel.saglikliyasam.presentation.ui.fragment.medicines

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.serapercel.saglikliyasam.R
import com.serapercel.saglikliyasam.databinding.FragmentMedicinesBinding
import com.serapercel.saglikliyasam.model.Medicine
import com.serapercel.saglikliyasam.model.medicineList
import com.serapercel.saglikliyasam.presentation.adapter.MedicineAdapter

class MedicinesFragment : Fragment() {

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
        populateMedicine()
        binding.medicinesRecyclerView.layoutManager = LinearLayoutManager(context)
        val medicineAdapter = MedicineAdapter()
        binding.medicinesRecyclerView.adapter = medicineAdapter
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_medicinesFragment_to_medicineAddFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // todo "change mock data with real data"
    fun populateMedicine() {
        val medicine1 = Medicine(
            name = "Antibiotic",
            time = "20:00"
        )
        medicineList.add(medicine1)
        medicineList.add(medicine1)
        medicineList.add(medicine1)
        medicineList.add(medicine1)
        medicineList.add(medicine1)
        medicineList.add(medicine1)

    }
}