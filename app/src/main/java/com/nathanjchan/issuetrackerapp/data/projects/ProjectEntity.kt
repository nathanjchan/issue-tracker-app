package com.nathanjchan.issuetrackerapp.data.projects

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "projects")
data class ProjectEntity(
    @PrimaryKey val projectId: Long,
    @ColumnInfo(name = "timestamp_of_creation") val timestampOfCreation: Long,
    @ColumnInfo(name = "timestamp_of_last_edit") val timestampOfLastEdit: Long,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "ticket_ids") val ticketIds: List<Long>,
    @ColumnInfo(name = "account_ids_of_owners") val accountIdsOfOwners: List<Long>,
    @ColumnInfo(name = "account_ids_of_members") val accountIdsOfMembers: List<Long>,
)
