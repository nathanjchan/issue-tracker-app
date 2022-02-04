package com.nathanjchan.issuetrackerapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nathanjchan.issuetrackerapp.R
import com.nathanjchan.issuetrackerapp.data.model.TicketModel
import com.nathanjchan.issuetrackerapp.databinding.FragmentTicketsBinding

class TicketsFragment : Fragment() {
    private lateinit var binding: FragmentTicketsBinding
    private lateinit var recyclerViewAdapter: TicketsRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tickets, container, false)
        binding = FragmentTicketsBinding.bind(view)

        val recyclerView = binding.ticketsRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this.context)

        val testTicketModel = TicketModel(
            ticketId = 0L,
            timestampOfCreation = 1L,
            timestampOfLastEdit = 2L,
            title = "Test title",
            description = "Test description",
            ticketNumber = 3,
            projectId = 4L,
            accountIdOfCreator = 5L,
            accountIdOfAssignee = 6L
        )

        recyclerViewAdapter = TicketsRecyclerViewAdapter(arrayOf(testTicketModel, testTicketModel))
        recyclerView.adapter = recyclerViewAdapter

        return view
    }
}