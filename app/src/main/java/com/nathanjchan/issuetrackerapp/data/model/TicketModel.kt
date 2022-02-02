package com.nathanjchan.issuetrackerapp.data.model

data class TicketModel(
    val ticketId: Long,
    val timestampOfCreation: Long,
    val timestampOfLastEdit: Long,
    val title: String,
    val description: String,
    val ticketNumber: Int,
    val projectId: Long,
    val accountIdOfCreator: Long,
    val accountIdOfAssignee: Long,
)
