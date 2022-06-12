package com.serapercel.saglikliyasam.presentation.ui.fragment.meal_add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.serapercel.saglikliyasam.databinding.FragmentAddMealBinding
import com.serapercel.saglikliyasam.util.createDailyWorkRequest
import java.util.*

class AddMealFragment : Fragment() {

    private var _binding: FragmentAddMealBinding? = null
    private val binding get() = _binding!!

    private var chosenYear = 0
    private var chosenMonth = 0
    private var chosenDay = 0
    private var chosenHour = 0
    private var chosenMin = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddMealBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val descriptionText = binding.editTextMeal
        val button = binding.addButton
        val datePicker = binding.datePicker
        val timePicker = binding.timePicker
        val today = Calendar.getInstance()

        datePicker.init(
            today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)
        ) { _, year, month, day ->
            chosenYear = year
            chosenMonth = month
            chosenDay = day
        }

        timePicker.setOnTimeChangedListener { _, hour, minute ->
            chosenHour = hour
            chosenMin = minute
        }

        button.setOnClickListener {

            val userSelectedDateTime = Calendar.getInstance()
            userSelectedDateTime.set(chosenYear, chosenMonth, chosenDay, chosenHour, chosenMin)

            createDailyWorkRequest(
                chosenHour, chosenMin,
                descriptionText.text.toString(), requireContext()
            )

            Toast.makeText(requireContext(), "Hatırlatıcı Oluşturuldu!", Toast.LENGTH_SHORT).show()
        }
    }

}