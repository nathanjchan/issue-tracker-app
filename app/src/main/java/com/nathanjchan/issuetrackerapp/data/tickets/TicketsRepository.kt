package com.nathanjchan.issuetrackerapp.data.tickets

class TicketsRepository {
    private var cachedTickets: List<TicketModel>? = null
    private val ticketsRemoteDataSource = TicketsRemoteDataSource()

    fun getTickets(): List<TicketModel> {
        val ticketModel = ticketsRemoteDataSource.getTicket()
        // TODO: this should use the getTickets() function
        ticketModel?.run {
            cachedTickets = listOf(this)
            return cachedTickets as List<TicketModel>
        }
        return listOf(TicketModel())
    }
}