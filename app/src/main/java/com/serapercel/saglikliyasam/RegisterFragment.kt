package com.serapercel.saglikliyasam

import android.R
import android.content.Intent
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.serapercel.saglikliyasam.databinding.FragmentRegisterBinding


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
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = binding.root

        auth = Firebase.auth

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        print("onViewCrated İçinde")
        super.onViewCreated(view, savedInstanceState)
        binding.signInButton.setOnClickListener {
            val view=it
            name = binding.editTextName.text.toString()
            email = binding.editTextEmail.text.toString()
            password = binding.editTextNumberPassword.text.toString()

            if (email.equals("") || password.equals("") || name.equals("")) {
                Toast.makeText(context, "Bilgilerinizi Giriniz!", Toast.LENGTH_LONG).show()
                print("onViewCrated if İçinde")

            } else {
                print("onViewCrated else İçinde")

                auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
                    //success
                    val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
                    Navigation.findNavController(view).navigate(action)

                }.addOnFailureListener {
                    Toast.makeText(context, it.localizedMessage, Toast.LENGTH_LONG).show()
                }


            }
        }

    }
}