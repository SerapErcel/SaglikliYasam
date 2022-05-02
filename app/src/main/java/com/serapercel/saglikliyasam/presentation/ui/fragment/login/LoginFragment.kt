package com.serapercel.saglikliyasam.presentation.ui.fragment.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.serapercel.saglikliyasam.R
import com.serapercel.saglikliyasam.databinding.FragmentLoginBinding
import com.serapercel.saglikliyasam.util.toastLong
import com.serapercel.saglikliyasam.util.toastShort


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth
    private lateinit var email: String
    private lateinit var password: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        initClickListener()

    }

    private fun initClickListener() {
        binding.loginButton.setOnClickListener {
            email = binding.editTextEmail.text.toString()
            password = binding.editTextNumberPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                    }
                }.addOnFailureListener { exception ->
                    exception.localizedMessage?.let { it1 -> requireContext().toastLong(it1) }
                }
            } else {
                requireContext().toastShort(getString(R.string.enter_your_info))
            }
        }

        binding.signUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.forgotPasswordButton.setOnClickListener {
            email = binding.editTextEmail.text.toString()
            if (email.isNotEmpty()) {
                auth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        requireContext().toastShort(getString(R.string.link_sent))
                    } else {
                        requireContext().toastShort(getString(R.string.email_sending_error))
                    }
                }
            } else {
                requireContext().toastLong(getString(R.string.enter_your_email))

            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



