package com.nathanjchan.issuetrackerapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nathanjchan.issuetrackerapp.data.repository.TicketsRepository
import com.nathanjchan.issuetrackerapp.ui.state.TicketsUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TicketsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TicketsUiState())
    val uiState: StateFlow<TicketsUiState> = _uiState.asStateFlow()
    private val ticketsRepository = TicketsRepository()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { currentUiState ->
                currentUiState.copy(tickets = ticketsRepository.getTickets())
            }
        }
    }
}
