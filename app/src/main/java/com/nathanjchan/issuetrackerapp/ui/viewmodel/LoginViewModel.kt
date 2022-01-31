package com.nathanjchan.issuetrackerapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.nathanjchan.issuetrackerapp.data.repository.AccountsRepository
import com.nathanjchan.issuetrackerapp.ui.state.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(accountsRepository: AccountsRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    init {
        if (!accountsRepository.hasAccountInfoChanged()) {
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
