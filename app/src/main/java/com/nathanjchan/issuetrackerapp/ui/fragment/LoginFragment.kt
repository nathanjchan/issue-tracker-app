package com.nathanjchan.issuetrackerapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.nathanjchan.issuetrackerapp.R
import com.nathanjchan.issuetrackerapp.databinding.FragmentLoginBinding
import com.nathanjchan.issuetrackerapp.ui.viewmodel.LoginViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Do view binding for fragment.
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        binding = FragmentLoginBinding.bind(view)

        // Navigate to certain Fragment depending on UI state.
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState ->
                    when {
                        uiState.isLoggedIn -> {
                            val action = LoginFragmentDirections.actionLoginFragmentToTicketsFragment()
                            findNavController().navigate(action)
                        }
                        uiState.goToSignup -> {
                            val action = LoginFragmentDirections.actionLoginFragmentToSignupFragment()
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }

        // Attempt to login if user pressed login button.
        binding.loginButton.setOnClickListener {
            val email = binding.loginEmailEditText.text.toString()
            val password = binding.loginPasswordEditText.text.toString()
            viewModel.attemptLogin(email, password)
        }

        // Go to signup if user pressed signup button.
        binding.loginToSignupButton.setOnClickListener {
            viewModel.wantsToSignUp()
        }

        return view
    }
}
