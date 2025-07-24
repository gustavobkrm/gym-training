package com.example.gymtraining.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.gymtraining.DestinosGymTraining
import com.example.gymtraining.ui.listexercises.EditGymDay
import com.example.gymtraining.ui.listexercises.EditGymDayViewModel

fun NavGraphBuilder.editGymDayGraph(
    navController: NavHostController
) {
    composable(
        route = DestinosGymTraining.ListExercises.rota,
        arguments = listOf(navArgument("dayId") { type = NavType.LongType })
    ) { navBackStackEntry ->
        navBackStackEntry.arguments?.getLong("dayId")?.let { dayId ->
            val viewModel = hiltViewModel<EditGymDayViewModel>()
            val state by viewModel.uiState.collectAsState()

            val onNavigateToAddNewExercise = {
                navController.navigate(
                    DestinosGymTraining.NewExercises.rota.replace("{dayId}", dayId.toString())
                )
            }

            val scope = rememberCoroutineScope()
            val context = LocalContext.current

            EditGymDay(
                state = state.copy(
                    onNavigateToAddNewExercise = onNavigateToAddNewExercise
                )
            )
        }
    }

}