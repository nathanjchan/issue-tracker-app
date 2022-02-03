package com.nathanjchan.issuetrackerapp

import com.nathanjchan.issuetrackerapp.data.model.AccountModel
import com.nathanjchan.issuetrackerapp.data.source.AccountsRemoteDataSource
import org.junit.Assert
import org.junit.Test

class TestAccountsRemoteDataSource {

    @Test
    fun testGetAccount() {
        val givenAccountModel = AccountModel(
            accountId = 1L,
            timestampOfCreation = 1L,
            timestampOfLastEdit = 1L,
            email = "test@test.com",
            password = "Test123",
            ticketIdsAsCreator = listOf(1L, 2L, 3L),
            ticketIdsAsAssignee = listOf(4L, 5L, 6L),
            projectIdsAsOwner = listOf(7L, 8L, 9L),
            projectIdsAsMember = listOf(10L, 11L, 12L)
        )

        val accountsRemoteDataSource = AccountsRemoteDataSource()
        val newAccountModel = accountsRemoteDataSource.getAccount(givenAccountModel)
        Assert.assertNotNull(newAccountModel)
        newAccountModel?.run {
//            Assert.assertEquals(...)
        }
    }

    @Test
    fun testHelloString() {
        val accountsRemoteDataSource = AccountsRemoteDataSource()
        val helloString = accountsRemoteDataSource.getHelloString()
        Assert.assertEquals("hello\n", helloString)
    }
}
