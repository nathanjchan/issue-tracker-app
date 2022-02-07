package com.nathanjchan.issuetrackerapp.ui.tickets

import com.nathanjchan.issuetrackerapp.data.tickets.TicketModel

data class TicketsUiState(
    val tickets: List<TicketModel> = listOf(TicketModel()),
)
