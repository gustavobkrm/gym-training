package com.example.gymtraining.ui.listexercises

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EditGymDayViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    private val _uiState = MutableStateFlow(EditGymDayUiState())
    val uiState: StateFlow<EditGymDayUiState>
        get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch {


        }
    }
}