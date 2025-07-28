package com.example.gymtraining.ui.listexercises

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gymtraining.database.ExerciseDAO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditGymDayViewModel @Inject constructor(
    private val exerciseDao : ExerciseDAO,
    savedStateHandle: SavedStateHandle) : ViewModel() {
    private val _uiState = MutableStateFlow(EditGymDayUiState())
    val uiState: StateFlow<EditGymDayUiState>
        get() = _uiState.asStateFlow()

    val dayId: Long = checkNotNull(savedStateHandle["dayId"]){}

    init {
        Log.d("ViewModel", "dayId: $dayId")

        viewModelScope.launch {
            val listaExercicios = exerciseDao.getExercisesByTrainingDay(dayId)
            _uiState.value = _uiState.value.copy(
                exerciciosDoDia = listaExercicios
            )
        }
    }
}