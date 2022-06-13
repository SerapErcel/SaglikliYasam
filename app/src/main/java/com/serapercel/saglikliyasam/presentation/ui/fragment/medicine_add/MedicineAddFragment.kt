package com.serapercel.saglikliyasam.presentation.ui.fragment.medicine_add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.serapercel.saglikliyasam.databinding.FragmentAddMedicineBinding
import com.serapercel.saglikliyasam.model.Medicine
import com.serapercel.saglikliyasam.util.createDailyMedicineWorkRequest

class MedicineAddFragment : Fragment() {

    private lateinit var viewModel: MedicineAddViewModel

    private var _binding: FragmentAddMedicineBinding? = null
    private val binding get() = _binding!!

    private var chosenHour = 0
    private var chosenMin = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddMedicineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val descriptionText = binding.editTextMedicine
        val button = binding.addMedicineButton
        val timePicker = binding.timePickerMedicine

        viewModel = ViewModelProvider(requireActivity()).get(MedicineAddViewModel::class.java)


        timePicker.setOnTimeChangedListener { _, hour, minute ->
            chosenHour = hour
            chosenMin = minute
        }

        button.setOnClickListener {

            createDailyMedicineWorkRequest(
                chosenHour, chosenMin,
                descriptionText.text.toString(), requireContext()
            )


            viewModel.storeInSQLite(Medicine(
                descriptionText.text.toString(),
                "$chosenHour:$chosenMin"
            ))

            Toast.makeText(requireContext(), "İlaç Hatırlatıcısı Oluşturuldu!", Toast.LENGTH_SHORT)
                .show()

            val action =
                MedicineAddFragmentDirections.actionMedicineAddFragmentToMedicinesFragment()
            findNavController().navigate(action)
        }
    }

}