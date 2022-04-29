package com.serapercel.saglikliyasam.presentation.ui.fragment.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.serapercel.saglikliyasam.R
import com.serapercel.saglikliyasam.databinding.FragmentRegisterBinding
import com.serapercel.saglikliyasam.util.toastLong
import com.serapercel.saglikliyasam.util.toastShort


class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var name: String

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth
        initClickListener()
    }

    private fun initClickListener() {
        binding.signInButton.setOnClickListener {
            name = binding.editTextName.text.toString()
            email = binding.editTextEmail.text.toString()
            password = binding.editTextNumberPassword.text.toString()

            if (email.isNotEmpty() || password.isNotEmpty() || name.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
                    //success
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)

                }.addOnFailureListener { exception ->
                    exception.localizedMessage?.let { it1 -> requireContext().toastLong(it1) }
                }
            } else {
                requireContext().toastShort(getString(R.string.enter_your_info))


            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}