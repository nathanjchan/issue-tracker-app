package com.nathanjchan.issuetrackerapp.data.tickets

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tickets")
data class TicketEntity(
    @PrimaryKey val ticketId: Long,
    @ColumnInfo(name = "timestamp_of_creation") val timestampOfCreation: Long,
    @ColumnInfo(name = "timestamp_of_last_edit") val timestampOfLastEdit: Long,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "ticketNumber") val ticketNumber: Int,
    @ColumnInfo(name = "project_id") val projectId: Long,
    @ColumnInfo(name = "account_id_of_creator") val accountIdOfCreator: Long,
    @ColumnInfo(name = "account_id_of_assignee") val accountIdOfAssignee: Long,
)