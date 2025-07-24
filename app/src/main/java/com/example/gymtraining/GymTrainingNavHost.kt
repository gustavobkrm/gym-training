package com.example.gymtraining

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.gymtraining.navigation.addNewExercisesGraph
import com.example.gymtraining.navigation.editGymDayGraph
import com.example.gymtraining.navigation.mainScreenGraph

@Composable
fun GymTrainingNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinosGymTraining.HomeGraph.rota,
        modifier = modifier
    ) {
        mainScreenGraph(navController)
        editGymDayGraph(navController)
        addNewExercisesGraph(navController)
    }
}

fun NavHostController.navegaDireto(rota: String) = this.navigate(rota) {
    popUpTo(this@navegaDireto.graph.findStartDestination().id) {
        saveState = true
    }
    launchSingleTop = true
    restoreState = true
}

fun NavHostController.navegaParaEditDay(dayId: Long) {
    val rota = DestinosGymTraining.ListExercises.rota.replace("{dayId}", dayId.toString())
    Log.d("Navegação", "Navegando para $rota")
    navegaDireto(rota)
}