package com.nathanjchan.issuetrackerapp.data.model

data class ProjectModel(
    val projectId: Long,
    val timestampOfCreation: Long,
    val timestampOfLastEdit: Long,
    val title: String,
    val description: String,
    val ticketIds: List<Long>,
    val accountIdsOfOwners: List<Long>,
    val accountIdsOfMembers: List<Long>,
)
