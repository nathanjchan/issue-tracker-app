package com.nathanjchan.issuetrackerapp.data.accounts

import androidx.room.*

@Dao
interface AccountsLocalApi {
    @Query("select * from accounts")
    fun getAll(): List<AccountEntity>

    @Insert
    fun insertAll(vararg accounts: AccountEntity)

    @Update
    fun updateUsers(vararg accounts: AccountEntity)

    @Delete
    fun delete(account: AccountEntity)
}