package com.hellodev.taskapp.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hellodev.taskapp.R
import com.hellodev.taskapp.databinding.FragmentLoginBinding
import com.hellodev.taskapp.util.showBottomSheet


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initiListiner()
    }

    private fun initiListiner() {
        binding.btnLogin.setOnClickListener {
            validateData()

        }

        binding.btnRegister.setOnClickListener() {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.btnRecover.setOnClickListener() {
            findNavController().navigate(R.id.action_loginFragment_to_recoverAccountFragment)
        }
    }

    private fun validateData() {
        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()

        if (email.isNotEmpty()) {
            if (password.isNotEmpty()) {
                findNavController().navigate(R.id.action_global_homeFragment)

            } else {
                showBottomSheet(message = getString(R.string.password_empty))
            }

        } else {
            showBottomSheet(message = getString(R.string.email_empty))
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}