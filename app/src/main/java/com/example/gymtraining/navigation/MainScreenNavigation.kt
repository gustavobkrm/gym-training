package com.example.gymtraining.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.gymtraining.DestinosGymTraining
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gymtraining.navegaParaEditDay
import com.example.gymtraining.ui.home.MainScreen
import com.example.gymtraining.ui.home.MainScreenViewModel


fun NavGraphBuilder.mainScreenGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = DestinosGymTraining.MainScreen.rota,
        route = DestinosGymTraining.HomeGraph.rota
    ){
        composable(DestinosGymTraining.MainScreen.rota){
            val viewModel = hiltViewModel<MainScreenViewModel>()
            val state by viewModel.uiState.collectAsState()

            MainScreen(
                state = state,
                onClickAbreDia = { dayId ->
                    navController.navegaParaEditDay(dayId)
                }
            )
        }

    }
}