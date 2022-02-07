package com.nathanjchan.issuetrackerapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nathanjchan.issuetrackerapp.R
import com.nathanjchan.issuetrackerapp.databinding.FragmentTicketsBinding
import com.nathanjchan.issuetrackerapp.ui.viewmodel.TicketsViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TicketsFragment : Fragment() {
    private lateinit var binding: FragmentTicketsBinding
    private lateinit var recyclerViewAdapter: TicketsRecyclerViewAdapter
    private val viewModel: TicketsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Do view binding for fragment.
        val view = inflater.inflate(R.layout.fragment_tickets, container, false)
        binding = FragmentTicketsBinding.bind(view)

        // Set up Recycler View.
        val recyclerView = binding.ticketsRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this.context)

        // Set the Recycler View Adapter to whatever is in the UI state.
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState ->
                    recyclerViewAdapter = TicketsRecyclerViewAdapter(uiState.tickets)
                    recyclerView.adapter = recyclerViewAdapter
                }
            }
        }

        return view
    }
}