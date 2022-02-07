package com.nathanjchan.issuetrackerapp.ui.login

data class LoginUiState(
    val isLoggedIn: Boolean = false,
    val goToSignup: Boolean = false,
    val message: String = "",
)
