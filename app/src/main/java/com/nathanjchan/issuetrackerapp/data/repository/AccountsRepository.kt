package com.nathanjchan.issuetrackerapp.data.repository

import com.nathanjchan.issuetrackerapp.data.model.AccountApiModel

class AccountsRepository {
    private val cachedAccount: AccountApiModel? = null

    init {
        // Fetch cached account from AccountsLocalDataSource
        // Use cached account to get latest account info from AccountsRemoteDataSource
        // If cached account and latest account match, then set cached account to the account from
        //     the local store.
        // If they do not match, then leave cachedAccount to null.
    }

    fun needNewAccountInfo(): Boolean {
        if (cachedAccount == null) {
            return true
        }
        return false
    }

    fun isValidAccount(email: String, password: String) {

    }
}
