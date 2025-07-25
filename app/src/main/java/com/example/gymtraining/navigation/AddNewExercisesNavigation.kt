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
import com.example.gymtraining.data.Category
import com.example.gymtraining.data.TrainingDayExerciseCrossRef
import com.example.gymtraining.database.GymTrainingDatabase
import com.example.gymtraining.ui.listexercises.EditGymDay
import com.example.gymtraining.ui.listexercises.EditGymDayViewModel
import com.example.gymtraining.ui.newexercise.AddNewExerciseViewModel
import com.example.gymtraining.ui.newexercise.AddNewExercises
import kotlinx.coroutines.launch

fun NavGraphBuilder.addNewExercisesGraph(
    navController: NavHostController
) {
    composable(
        route = DestinosGymTraining.NewExercises.rota,
        arguments = listOf(navArgument("dayId") { type = NavType.LongType })
    ) { navBackStackEntry ->
        navBackStackEntry.arguments?.getLong("dayId")?.let { dayId ->
            val viewModel = hiltViewModel<AddNewExerciseViewModel>()
            val state by viewModel.uiState.collectAsState()
            val context = LocalContext.current

            val trainingDayExerciseCrossRefDao =
                GymTrainingDatabase.getDatabase(context).trainingDayExerciseCrossRefDao()
            val coroutineScope = rememberCoroutineScope()

            AddNewExercises(
                state = state,
                onClickSalvar = {
                    with(state) {
                        if (selectedExercise != null)
                            coroutineScope.launch {
                                trainingDayExerciseCrossRefDao.insert(
                                    TrainingDayExerciseCrossRef(
                                        trainingDayId = dayId,
                                        exerciseId = selectedExercise.exerciseId
                                    )
                                )
                            }
                    }
                }
            )
        }
    }

}