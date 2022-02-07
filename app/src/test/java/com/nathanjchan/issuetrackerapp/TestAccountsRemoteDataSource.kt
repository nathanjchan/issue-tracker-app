package com.nathanjchan.issuetrackerapp

import com.nathanjchan.issuetrackerapp.data.accounts.AccountModel
import com.nathanjchan.issuetrackerapp.data.accounts.AccountsRemoteDataSource
import org.junit.Assert
import org.junit.Test

class TestAccountsRemoteDataSource {
    private val accountsRemoteDataSource = AccountsRemoteDataSource()
    private val accountModel = AccountModel(
        accountId = 1L,
        timestampOfCreation = 2L,
        timestampOfLastEdit = 3L,
        email = "test@test.com",
        password = "Test123",
        ticketIdsAsCreator = listOf(1L, 2L, 3L),
        ticketIdsAsAssignee = listOf(4L, 5L, 6L),
        projectIdsAsOwner = listOf(7L, 8L, 9L),
        projectIdsAsMember = listOf(10L, 11L, 12L)
    )

    @Test
    fun testGetAccount() {
        val newAccountModel = accountsRemoteDataSource.getAccount(accountModel)
        Assert.assertNotNull(newAccountModel)
        newAccountModel?.run {
//            Assert.assertEquals(...)
        }
    }

    @Test
    fun testHelloString() {
        val helloString = accountsRemoteDataSource.getHelloString()
        Assert.assertEquals("hello\n", helloString)
    }
}
