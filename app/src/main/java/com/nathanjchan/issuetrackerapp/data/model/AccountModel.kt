package com.nathanjchan.issuetrackerapp.data.model

data class AccountModel(
    val accountId: Long = 0,
    val timestampOfCreation: Long = 0,
    val timestampOfLastEdit: Long = 0,
    val email: String = "",
    val password: String = "",
    val ticketIdsAsCreator: List<Long> = listOf(0),
    val ticketIdsAsAssignee: List<Long> = listOf(0),
    val projectIdsAsOwner: List<Long> = listOf(0),
    val projectIdsAsMember: List<Long> = listOf(0),
)
