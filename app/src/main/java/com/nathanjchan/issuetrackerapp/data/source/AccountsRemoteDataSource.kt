package com.nathanjchan.issuetrackerapp.data.source

import IssueTrackerApiObjects
import com.nathanjchan.issuetrackerapp.data.api.AccountsRemoteApi
import com.nathanjchan.issuetrackerapp.data.model.AccountModel

class AccountsRemoteDataSource {

    private fun getAccountProtobufFromModel(accountModel: AccountModel): IssueTrackerApiObjects.Account {
        accountModel.run {
            return IssueTrackerApiObjects.Account.newBuilder()
                .setAccountId(accountId)
                .setTimestampOfCreation(timestampOfCreation)
                .setTimestampOfLastEdit(timestampOfLastEdit)
                .setEmail(email)
                .setPassword(password)
                .addAllTicketIdsAsCreator(ticketIdsAsCreator)
                .addAllTicketIdsAsAssignee(ticketIdsAsAssignee)
                .addAllProjectIdsAsOwner(projectIdsAsOwner)
                .addAllProjectIdsAsMember(projectIdsAsMember)
                .build()
        }
    }

    private fun getAccountModelFromProtobuf(accountProtobuf: IssueTrackerApiObjects.Account): AccountModel {
        accountProtobuf.run {
            return AccountModel(
                accountId = accountId,
                timestampOfCreation = timestampOfCreation,
                timestampOfLastEdit = timestampOfLastEdit,
                email = email,
                password = password,
                ticketIdsAsCreator = ticketIdsAsCreatorList,
                ticketIdsAsAssignee = ticketIdsAsAssigneeList,
                projectIdsAsOwner = projectIdsAsOwnerList,
                projectIdsAsMember = projectIdsAsMemberList
            )
        }
    }

    fun getAccount(accountModel: AccountModel): AccountModel? {
        val accountProtobuf = getAccountProtobufFromModel(accountModel)
        val accountsRemoteApi = AccountsRemoteApi.create().getAccount(accountProtobuf)
        return accountsRemoteApi.execute().body()?.let {
            getAccountModelFromProtobuf(it)
        }
    }

    fun getHelloString(): String {
        val accountsRemoteApi = AccountsRemoteApi.create().getHelloString()
        return accountsRemoteApi.execute().body().toString()
    }
}
