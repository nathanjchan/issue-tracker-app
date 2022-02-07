package com.nathanjchan.issuetrackerapp.ui.ticket

import java.util.*

data class TicketUiState(
    val number: Int,
    val title: String,
    val description: String,
    val dateOfCreation: Date,
    val dateOfLastEdit: Date,
    val creator: String,
    val assignee: String,
    val project: String,
)
