package com.nathanjchan.issuetrackerapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nathanjchan.issuetrackerapp.data.accounts.AccountsLocalApi
import com.nathanjchan.issuetrackerapp.data.accounts.AccountEntity
import com.nathanjchan.issuetrackerapp.data.projects.ProjectEntity
import com.nathanjchan.issuetrackerapp.data.projects.ProjectsLocalApi
import com.nathanjchan.issuetrackerapp.data.tickets.TicketEntity
import com.nathanjchan.issuetrackerapp.data.tickets.TicketsLocalApi

@Database(entities = [AccountEntity::class, ProjectEntity::class, TicketEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun accountsLocalApi(): AccountsLocalApi
    abstract fun projectsLocalApi(): ProjectsLocalApi
    abstract fun ticketsLocalApi(): TicketsLocalApi
}