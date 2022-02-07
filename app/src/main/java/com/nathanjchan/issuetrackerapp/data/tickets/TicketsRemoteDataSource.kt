package com.nathanjchan.issuetrackerapp.data.tickets

class TicketsRemoteDataSource {

    private fun getTicketProtobufFromModel(ticketModel: TicketModel): IssueTrackerApiObjects.Ticket {
        ticketModel.run {
            return IssueTrackerApiObjects.Ticket.newBuilder()
                .setTicketId(ticketId)
                .setTimestampOfCreation(timestampOfCreation)
                .setTimestampOfLastEdit(timestampOfLastEdit)
                .setTitle(title)
                .setDescription(description)
                .setTicketNumber(ticketNumber)
                .setProjectId(projectId)
                .setAccountIdOfCreator(accountIdOfCreator)
                .setAccountIdOfAssignee(accountIdOfAssignee)
                .build()
        }
    }

    private fun getTicketModelFromProtobuf(ticketProtobuf: IssueTrackerApiObjects.Ticket): TicketModel {
        ticketProtobuf.run {
            return TicketModel(
                ticketId = ticketId,
                timestampOfCreation = timestampOfCreation,
                timestampOfLastEdit = timestampOfLastEdit,
                title = title,
                description = description,
                ticketNumber = ticketNumber,
                projectId = projectId,
                accountIdOfCreator = accountIdOfCreator,
                accountIdOfAssignee = accountIdOfAssignee
            )
        }
    }

    fun getTicket(): TicketModel? {
        // TODO: Should take in a ticketId for API call.
        // TODO: Have a getTickets function that calls this function for many ticketIds.
//        val ticketProtobuf = getTicketProtobufFromModel(ticketModel)
//        val ticketsRemoteApi = TicketsRemoteApi.create().getTicket(ticketProtobuf)
        val ticketsRemoteApi = TicketsRemoteApi.create().getTicket()
        return ticketsRemoteApi.execute().body()?.let {
            getTicketModelFromProtobuf(it)
        }
    }
}
