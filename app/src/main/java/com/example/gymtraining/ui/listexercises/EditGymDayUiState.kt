package com.example.gymtraining.ui.listexercises

import androidx.lifecycle.viewModelScope
import com.example.gymtraining.ui.home.MainScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class EditGymDayUiState(
    val onNavigateToAddNewExercise: (Long) -> Unit = {},
    val possuiTreino: Boolean = false

    )

