package com.nathanjchan.issuetrackerapp

import com.nathanjchan.issuetrackerapp.data.tickets.TicketModel
import com.nathanjchan.issuetrackerapp.data.tickets.TicketsRemoteDataSource
import org.junit.Assert
import org.junit.Test

class TestTicketsRemoteDataSource {
    private val ticketsRemoteDataSource = TicketsRemoteDataSource()
    private val ticketModel = TicketModel(
        ticketId = 9,
        timestampOfCreation = 8,
        timestampOfLastEdit = 7,
        title = "How To Train Your Dragon",
        description = "The greatest film series of all time.",
        ticketNumber = 6,
        projectId = 5,
        accountIdOfCreator = 4,
        accountIdOfAssignee = 3
    )

    @Test
    fun testGetTicket() {
        val newTicketModel = ticketsRemoteDataSource.getTicket()
        Assert.assertNotNull(newTicketModel)
        newTicketModel?.run {
            Assert.assertEquals(title, "Lord of the Rings")
        }
    }
}