package com.example.gymtraining.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.gymtraining.DestinosGymTraining
import com.example.gymtraining.database.GymTrainingDatabase
import com.example.gymtraining.ui.listexercises.EditGymDay
import com.example.gymtraining.ui.listexercises.EditGymDayUiState
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

            val onNavigateToAddNewExercise: (Long) -> Unit = { dayId ->
                navController.navigate(
                    DestinosGymTraining.NewExercises.rota.replace("{dayId}", dayId.toString())
                )
            }

            val context = LocalContext.current
            val dao = remember { GymTrainingDatabase.getDatabase(context).trainingDayExerciseCrossRefDao() }
            var possuiTreino by remember { mutableStateOf<Boolean?>(null) }

            LaunchedEffect(dayId) {
                possuiTreino = dao.hasExercisesForDay(dayId)
            }

            if (possuiTreino != null) {
                EditGymDay(
                    state = state.copy(
                        onNavigateToAddNewExercise = onNavigateToAddNewExercise,
                        possuiTreino = possuiTreino!!
                    ),
                    dayId = dayId
                )
            }
        }
    }

}