package com.example.gymtraining.ui.newexercise

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gymtraining.data.Exercise
import com.example.gymtraining.ui.home.MainScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AddNewExerciseViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    private val _uiState = MutableStateFlow(AddNewExerciseUiState())
    val uiState: StateFlow<AddNewExerciseUiState>
        get() = _uiState.asStateFlow()

    init{
        viewModelScope.launch {

        }
    }
}