package com.nathanjchan.issuetrackerapp.ui.state

import com.nathanjchan.issuetrackerapp.data.model.TicketModel

data class TicketsUiState(
    val tickets: List<TicketModel> = listOf(TicketModel()),
)
