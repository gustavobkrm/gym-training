package com.example.gymtraining

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class DestinosGymTraining(val rota: String) {
    object HomeGraph : DestinosGymTraining("main_graph")
    object MainScreen : DestinosGymTraining("main_screen")
    object ListExercises : DestinosGymTraining("edit_gym_day/{dayId}")
    object NewExercises : DestinosGymTraining("add_new_exercises/{dayId}")
}

