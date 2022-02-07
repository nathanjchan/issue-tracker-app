package com.nathanjchan.issuetrackerapp.data.model

data class TicketModel(
    val ticketId: Long = 0,
    val timestampOfCreation: Long = 0,
    val timestampOfLastEdit: Long = 0,
    val title: String = "",
    val description: String = "",
    val ticketNumber: Int = 0,
    val projectId: Long = 0,
    val accountIdOfCreator: Long = 0,
    val accountIdOfAssignee: Long = 0,
)
