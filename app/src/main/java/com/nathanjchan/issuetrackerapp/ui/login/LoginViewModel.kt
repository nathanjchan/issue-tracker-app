package com.nathanjchan.issuetrackerapp.ui.login

import androidx.lifecycle.ViewModel
import com.nathanjchan.issuetrackerapp.data.accounts.AccountsRepository
import com.nathanjchan.issuetrackerapp.ui.login.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()
    private val accountsRepository = AccountsRepository()

    init {
        if (!accountsRepository.needNewAccountInfo()) {
            _uiState.update { currentUiState ->
                currentUiState.copy(isLoggedIn = true)
            }
        }
    }

    fun wantsToSignUp() {
        _uiState.update { currentUiState ->
            currentUiState.copy(goToSignup = true)
        }
    }

    fun attemptLogin(email: String, password: String) {

    }
}
