package com.nathanjchan.issuetrackerapp.data.api

import IssueTrackerApiObjects
import com.nathanjchan.issuetrackerapp.data.api.retrofitconverter.ProtoConverterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET

interface TicketsRemoteApi {

    @GET("get-proto")
//    fun getTicket(@Body ticketProtobuf: IssueTrackerApiObjects.Ticket): Call<IssueTrackerApiObjects.Ticket>
    fun getTicket(): Call<IssueTrackerApiObjects.Ticket>


    companion object {
        private const val BASE_URL = "http://54.241.64.13:8090/"

        fun create(): TicketsRemoteApi {
            return Retrofit.Builder()
                .addConverterFactory(ProtoConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(TicketsRemoteApi::class.java)
        }
    }

//    fun postTicket(ticket: TicketModel) {
//        val ticketByteArray = createTicketProtobuf(ticket)
//    }

//    fun getTicket(ticket: TicketModel) {
//        val ticketByteArray = createTicketProtobuf(ticket)
//    }
}
