package com.serapercel.saglikliyasam

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.navigation.Navigation
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.serapercel.saglikliyasam.databinding.FragmentLoginBinding


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
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        auth = FirebaseAuth.getInstance()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginButton.setOnClickListener {
            val view = it
            email = binding.editTextEmail.text.toString()
            password = binding.editTextNumberPassword.text.toString()

            if (email.equals("") || password.equals("")) {
                Toast.makeText(context, "Bilgilerinizi Giriniz!", Toast.LENGTH_LONG).show()

            } else {
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
                        Navigation.findNavController(view).navigate(action)
                    }
                }.addOnFailureListener { exception ->
                    Toast.makeText(context, exception.localizedMessage, Toast.LENGTH_LONG).show()
                }

            }
        }
        binding.signUpButton.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            Navigation.findNavController(view).navigate(action)
        }

        binding.forgotPasswordButton.setOnClickListener {
            email = binding.editTextEmail.text.toString()
            if (email.equals("")) {
                Toast.makeText(context, "E Mail Adresinizi Giriniz!", Toast.LENGTH_LONG).show()

            } else {
                auth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            context,
                            "Yeni parola için gerekli bağlantı adresinize gönderildi!",
                            Toast.LENGTH_SHORT
                        ).show();
                    } else {
                        Toast.makeText(context, "Mail gönderme hatası!", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        }

    }

}


