package com.nathanjchan.issuetrackerapp.data.model

data class ProjectModel(
    val projectId: Long = 0,
    val timestampOfCreation: Long = 0,
    val timestampOfLastEdit: Long = 0,
    val title: String = "",
    val description: String = "",
    val ticketIds: List<Long> = listOf(0),
    val accountIdsOfOwners: List<Long> = listOf(0),
    val accountIdsOfMembers: List<Long> = listOf(0),
)
