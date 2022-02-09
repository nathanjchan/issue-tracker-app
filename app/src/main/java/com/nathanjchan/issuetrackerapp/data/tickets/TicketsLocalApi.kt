package com.nathanjchan.issuetrackerapp.data.tickets

import androidx.room.*

@Dao
interface TicketsLocalApi {
    @Query("select * from tickets")
    fun getAll(): List<TicketEntity>

    @Insert
    fun insertAll(vararg tickets: TicketEntity)

    @Update
    fun updateUsers(vararg tickets: TicketEntity)

    @Delete
    fun delete(tickets: TicketEntity)
}