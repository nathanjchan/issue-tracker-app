package com.nathanjchan.issuetrackerapp.data.api

import IssueTrackerApiObjects
import com.nathanjchan.issuetrackerapp.data.api.retrofitconverter.ScalarsConverterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET

interface AccountsRemoteApi {

    @GET("")
    fun getAccount(@Body account: IssueTrackerApiObjects.Account): Call<IssueTrackerApiObjects.Account>

    @GET("hello")
    fun getHelloString(): Call<String>

    companion object {
        private const val BASE_URL = "http://54.241.64.13:8090/"

        fun create(): AccountsRemoteApi {
            return Retrofit.Builder()
//                .addConverterFactory(ProtoConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(AccountsRemoteApi::class.java)
        }
    }

//    fun postAccount(account: AccountApiModel) {
//        val accountByteArray = createAccountProtobuf(account)
//    }

//    fun getAccount(account: AccountApiModel) {
//        val accountByteArray = createAccountProtobuf(account)
//    }
}
