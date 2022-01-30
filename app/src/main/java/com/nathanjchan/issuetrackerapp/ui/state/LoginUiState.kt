package com.nathanjchan.issuetrackerapp.ui.state

data class LoginUiState(
    val loginSuccessful: Boolean = false,
    val message: String = "",
)
