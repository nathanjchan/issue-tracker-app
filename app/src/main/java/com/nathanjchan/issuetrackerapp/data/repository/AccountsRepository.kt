package com.nathanjchan.issuetrackerapp.data.repository

import com.nathanjchan.issuetrackerapp.data.model.AccountApiModel
import javax.inject.Inject

class AccountsRepository @Inject constructor() {
    val cachedAccount: AccountApiModel? = null

    fun hasAccountInfoChanged(): Boolean {
        return true
    }

    fun isValidAccount(email: String, password: String) {

    }
}
