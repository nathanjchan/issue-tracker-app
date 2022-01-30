package com.nathanjchan.issuetrackerapp.data.model

data class AccountApiModel(
    val accountId: Long,
    val timestampOfCreation: Long,
    val timestampOfLastEdit: Long,
    val email: String,
    val password: String,
    val ticketIdsAsCreator: List<Long>,
    val ticketIdsAsAssignee: List<Long>,
    val projectIdsAsOwner: List<Long>,
    val projectIdsAsMember: List<Long>,
)
