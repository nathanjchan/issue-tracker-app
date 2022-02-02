package com.nathanjchan.issuetrackerapp.data.api

import com.nathanjchan.issuetrackerapp.data.model.TicketModel

interface TicketsRemoteApi {
    private fun createTicketProtobuf(ticket: TicketModel): ByteArray {
        val ticketProtobuf = IssueTrackerApiObjects.Ticket.newBuilder()
            .setTicketId(ticket.ticketId)
            .setTimestampOfCreation(ticket.timestampOfCreation)
            .setTimestampOfLastEdit(ticket.timestampOfLastEdit)
            .setTitle(ticket.title)
            .setDescription(ticket.description)
            .setTicketNumber(ticket.ticketNumber)
            .setProjectId(ticket.projectId)
            .setAccountIdOfCreator(ticket.accountIdOfCreator)
            .setAccountIdOfAssignee(ticket.accountIdOfAssignee)
        return ticketProtobuf.build().toByteArray()
    }

    fun postTicket(ticket: TicketModel) {
//        val ticketByteArray = createTicketProtobuf(ticket)
    }

    fun getTicket(ticket: TicketModel) {
//        val ticketByteArray = createTicketProtobuf(ticket)
    }
}