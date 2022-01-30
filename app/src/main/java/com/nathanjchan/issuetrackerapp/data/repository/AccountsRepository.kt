package com.nathanjchan.issuetrackerapp.data.repository

import com.nathanjchan.issuetrackerapp.data.model.AccountApiModel

class AccountsRepository {
    val cachedAccount: AccountApiModel? = null

    fun hasAccountInfoChanged(): Boolean {
        return false
    }

    fun isValidAccount(email: String, password: String) {

    }
}
