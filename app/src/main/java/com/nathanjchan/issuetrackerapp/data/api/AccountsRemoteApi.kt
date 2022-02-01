package com.nathanjchan.issuetrackerapp.data.api

import IssueTrackerApiObjects
import com.nathanjchan.issuetrackerapp.data.model.AccountApiModel

interface AccountsRemoteApi {
    private fun createAccountProtobuf(account: AccountApiModel): ByteArray {
        val accountProtobuf = IssueTrackerApiObjects.Account.newBuilder()
            .setAccountId(account.accountId)
            .setTimestampOfCreation(account.timestampOfCreation)
            .setTimestampOfLastEdit(account.timestampOfLastEdit)
            .setEmail(account.email)
            .setPassword(account.password)
        account.ticketIdsAsCreator.forEachIndexed { i, value ->
            accountProtobuf.setTicketIdsAsCreator(i, value)
        }
        account.ticketIdsAsAssignee.forEachIndexed { i, value ->
            accountProtobuf.setTicketIdsAsAssignee(i, value)
        }
        account.projectIdsAsOwner.forEachIndexed { i, value ->
            accountProtobuf.setProjectIdsAsOwner(i, value)
        }
        account.projectIdsAsMember.forEachIndexed { i, value ->
            accountProtobuf.setProjectIdsAsMember(i, value)
        }
        return accountProtobuf.build().toByteArray()
    }

    fun postAccount(account: AccountApiModel) {
//        val accountByteArray = createAccountProtobuf(account)
    }

    fun getAccount(account: AccountApiModel) {
//        val accountByteArray = createAccountProtobuf(account)
    }
}
