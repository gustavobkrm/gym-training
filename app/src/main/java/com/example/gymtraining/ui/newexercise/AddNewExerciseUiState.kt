package com.example.gymtraining.ui.newexercise

import com.example.gymtraining.data.Category
import com.example.gymtraining.data.Exercise

data class AddNewExerciseUiState(
    val selectedExercise: Exercise? = null,
    val selectedDay: Long = 0
    )
