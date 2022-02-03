package com.nathanjchan.issuetrackerapp.data.api

import com.nathanjchan.issuetrackerapp.data.api.retrofitconverter.ScalarsConverterFactory
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET

interface AccountsRemoteApi {

    @GET("")
    fun getAccount(@Body account: IssueTrackerApiObjects.Account) : Call<IssueTrackerApiObjects.Account>

    @GET("hello")
    fun getHelloString() : Call<String>

    companion object {
        var BASE_URL = "http://54.241.64.13:8090/"

        fun create() : AccountsRemoteApi {
            val retrofit = Retrofit.Builder()
//                .addConverterFactory(ProtoConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
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
