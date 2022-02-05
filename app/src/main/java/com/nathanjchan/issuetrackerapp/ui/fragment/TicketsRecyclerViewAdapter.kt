package com.nathanjchan.issuetrackerapp.ui.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nathanjchan.issuetrackerapp.R
import com.nathanjchan.issuetrackerapp.data.model.TicketModel

class TicketsRecyclerViewAdapter(private val ticketsDataSet: Array<TicketModel>) :
    RecyclerView.Adapter<TicketsRecyclerViewAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Define click listener for the ViewHolder's View (?)
        val ticketRowTextView: TextView = view.findViewById(R.id.ticketRowTextView)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.ticket_row_item, viewGroup, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val ticket = ticketsDataSet[position]
        val ticketString = "${ticket.ticketNumber}: ${ticket.title}"
        viewHolder.ticketRowTextView.text = ticketString
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = ticketsDataSet.size
}