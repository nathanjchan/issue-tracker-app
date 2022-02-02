package com.nathanjchan.issuetrackerapp.data.api

import IssueTrackerApiObjects
import com.nathanjchan.issuetrackerapp.data.api.retrofitconverterprotobuf.ProtoConverterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET

interface AccountsRemoteApi {

    @GET("")
    fun getAccount(@Body account: IssueTrackerApiObjects.Account) : Call<IssueTrackerApiObjects.Account>

    companion object {
        var BASE_URL = ""

        fun create() : AccountsRemoteApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(ProtoConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(AccountsRemoteApi::class.java)
        }
    }

//    fun postAccount(account: AccountApiModel) {
//        val accountByteArray = createAccountProtobuf(account)
//    }

//    fun getAccount(account: AccountApiModel) {
//        val accountByteArray = createAccountProtobuf(account)
//    }
}
