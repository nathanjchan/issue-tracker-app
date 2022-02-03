package com.nathanjchan.issuetrackerapp.data.source

import IssueTrackerApiObjects
import com.nathanjchan.issuetrackerapp.data.api.AccountsRemoteApi
import com.nathanjchan.issuetrackerapp.data.model.AccountModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AccountsRemoteDataSource {
    private fun getAccountProtobufFromModel(accountModel: AccountModel): IssueTrackerApiObjects.Account {
        val accountProtobuf = IssueTrackerApiObjects.Account.newBuilder()
            .setAccountId(accountModel.accountId)
            .setTimestampOfCreation(accountModel.timestampOfCreation)
            .setTimestampOfLastEdit(accountModel.timestampOfLastEdit)
            .setEmail(accountModel.email)
            .setPassword(accountModel.password)
        accountModel.ticketIdsAsCreator.forEachIndexed { i, value ->
            accountProtobuf.setTicketIdsAsCreator(i, value)
        }
        accountModel.ticketIdsAsAssignee.forEachIndexed { i, value ->
            accountProtobuf.setTicketIdsAsAssignee(i, value)
        }
        accountModel.projectIdsAsOwner.forEachIndexed { i, value ->
            accountProtobuf.setProjectIdsAsOwner(i, value)
        }
        accountModel.projectIdsAsMember.forEachIndexed { i, value ->
            accountProtobuf.setProjectIdsAsMember(i, value)
        }
        return accountProtobuf.build()
    }

    private fun getAccountModelFromProtobuf(accountProtobuf: IssueTrackerApiObjects.Account): AccountModel {
        return AccountModel(
            accountId = accountProtobuf.accountId,
            timestampOfCreation = accountProtobuf.timestampOfCreation,
            timestampOfLastEdit = accountProtobuf.timestampOfLastEdit,
            email = accountProtobuf.email,
            password = accountProtobuf.password,
            ticketIdsAsCreator = accountProtobuf.ticketIdsAsCreatorList,
            ticketIdsAsAssignee = accountProtobuf.ticketIdsAsAssigneeList,
            projectIdsAsOwner = accountProtobuf.projectIdsAsOwnerList,
            projectIdsAsMember = accountProtobuf.projectIdsAsMemberList
        )
    }

    fun getAccount(account: AccountModel): AccountModel? {
        val accountProtobuf = getAccountProtobufFromModel(account)
        val accountsRemoteApi = AccountsRemoteApi.create().getAccount(accountProtobuf)
//        accountsRemoteApi.enqueue( object : Callback<IssueTrackerApiObjects.Account> {
//            override fun onResponse(
//                call: Call<IssueTrackerApiObjects.Account>,
//                response: Response<IssueTrackerApiObjects.Account>
//            ) {
//                response.body()?.run {
//                    accountModel = getAccountModelFromProtobuf(this)
//                }
//            }
//            override fun onFailure(call: Call<IssueTrackerApiObjects.Account>, t: Throwable) {
//                // nothing yet
//            }
//        })
        return accountsRemoteApi.execute().body()?.let { getAccountModelFromProtobuf(it) }
    }

    fun getHelloString(): String {
        val accountsRemoteApi = AccountsRemoteApi.create().getHelloString()
        return accountsRemoteApi.execute().body().toString()
    }
}
