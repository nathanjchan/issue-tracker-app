package com.nathanjchan.issuetrackerapp.data.model

data class ProjectApiModel(
    val projectId: Long,
    val timestampOfCreation: Long,
    val timestampOfLastEdit: Long,
    val title: String,
    val description: String,
    val ticketIds: List<Long>,
    val accountIdsOfOwners: List<Long>,
    val accountsIdsOfMembers: List<Long>,
)
