package com.nathanjchan.issuetrackerapp.ui.state

data class LoginUiState(
    val isLoggedIn: Boolean = false,
    val goToSignup: Boolean = false,
    val message: String = "",
)
