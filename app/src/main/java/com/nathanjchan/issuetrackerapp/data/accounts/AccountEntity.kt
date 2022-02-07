package com.nathanjchan.issuetrackerapp.data.accounts

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AccountEntity(
    @PrimaryKey val accountId: Long,
    @ColumnInfo(name = "timestamp_of_creation") val timestampOfCreation: Long,
    @ColumnInfo(name = "timestamp_of_last_edit") val timestampOfLastEdit: Long,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "password") val password: String,
    @ColumnInfo(name = "ticket_ids_as_creator") val ticketIdsAsCreator: List<Long>,
    @ColumnInfo(name = "ticked_ids_as_assignee") val ticketIdsAsAssignee: List<Long>,
    @ColumnInfo(name = "project_ids_as_owner") val projectIdsAsOwner: List<Long>,
    @ColumnInfo(name = "project_ids_as_members") val projectIdsAsMember: List<Long>,
)
