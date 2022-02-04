package com.nathanjchan.issuetrackerapp.data.source

import com.nathanjchan.issuetrackerapp.data.api.TicketsRemoteApi
import com.nathanjchan.issuetrackerapp.data.model.TicketModel

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



    fun getTicket(ticketModel: TicketModel): TicketModel? {
        val ticketProtobuf = getTicketProtobufFromModel(ticketModel)
        val ticketsRemoteApi = TicketsRemoteApi.create().getTicket(ticketProtobuf)
        return ticketsRemoteApi.execute().body()?.let {
            getTicketModelFromProtobuf(it)
        }
    }
}
