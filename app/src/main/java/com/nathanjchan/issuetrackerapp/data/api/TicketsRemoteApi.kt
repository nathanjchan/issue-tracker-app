package com.nathanjchan.issuetrackerapp.data.api

import com.nathanjchan.issuetrackerapp.data.model.TicketApiModel

interface TicketsRemoteApi {
    private fun createTicketProtobuf(ticket: TicketApiModel): ByteArray {
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

    fun postTicket(ticket: TicketApiModel) {
//        val ticketByteArray = createTicketProtobuf(ticket)
    }

    fun getTicket(ticket: TicketApiModel) {
//        val ticketByteArray = createTicketProtobuf(ticket)
    }
}