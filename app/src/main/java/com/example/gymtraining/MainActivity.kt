package com.example.gymtraining

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.gymtraining.data.Category
import com.example.gymtraining.data.Exercise
import com.example.gymtraining.data.TrainingDay
import com.example.gymtraining.data.TrainingDayExerciseCrossRef
import com.example.gymtraining.database.GymTrainingDatabase
import com.example.gymtraining.ui.home.MainScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val categoryDao = GymTrainingDatabase.getDatabase(this).categoryDao()
        val exerciseDao = GymTrainingDatabase.getDatabase(this).exerciseDao()
        val trainingDay = GymTrainingDatabase.getDatabase(this).trainingDayDao()
        val trainingDayExerciseCrossRef = GymTrainingDatabase.getDatabase(this).trainingDayExerciseCrossRefDao()

        CoroutineScope(IO).launch {
            /*categoryDao.deleteAll()

            val categoryIds: List<Long> = categoryDao.insertAll(
                listOf(
                    Category(nome = "Peito"),
                    Category(nome = "Costas"),
                    Category(nome = "Pernas"),
                    Category(nome = "Bíceps"),
                    Category(nome = "Tríceps"),
                    Category(nome = "Ombros"),
                    Category(nome = "Abdômen")
                )
            )
            val allExercises = listOf(
                // Peito - categoryIds[0]
                Exercise(nome = "Supino Reto halteres", categoriaId = categoryIds[0]),
                Exercise(nome = "Supino Inclinado", categoriaId = categoryIds[0]),
                Exercise(nome = "Supino Declinado", categoriaId = categoryIds[0]),
                Exercise(nome = "Crucifixo", categoriaId = categoryIds[0]),
                Exercise(nome = "Pullover", categoriaId = categoryIds[0]),
                Exercise(nome = "CrossOver", categoriaId = categoryIds[0]),

                // Costas - categoryIds[1]
                Exercise(nome = "Puxada Frontal", categoriaId = categoryIds[1]),
                Exercise(nome = "Remada Unilateral", categoriaId = categoryIds[1]),
                Exercise(nome = "Levantamento Terra", categoriaId = categoryIds[1]),
                Exercise(nome = "Puxada Supinada", categoriaId = categoryIds[1]),
                Exercise(nome = "Remada Pronada", categoriaId = categoryIds[1]),
                Exercise(nome = "Remada Baixa", categoriaId = categoryIds[1]),
                Exercise(nome = "Crucifixo Inverso", categoriaId = categoryIds[1]),

                // Pernas - categoryIds[2]
                Exercise(nome = "Agachamento Hack", categoriaId = categoryIds[2]),
                Exercise(nome = "Leg Press", categoriaId = categoryIds[2]),
                Exercise(nome = "Cadeira Extensora", categoriaId = categoryIds[2]),
                Exercise(nome = "Cadeira Flexora", categoriaId = categoryIds[2]),
                Exercise(nome = "Stiff", categoriaId = categoryIds[2]),
                Exercise(nome = "Afundo", categoriaId = categoryIds[2]),
                Exercise(nome = "Panturrilha em pé", categoriaId = categoryIds[2]),
                Exercise(nome = "Elevação Pélvica", categoriaId = categoryIds[2]),

                // Bíceps - categoryIds[3]
                Exercise(nome = "Rosca Direta", categoriaId = categoryIds[3]),
                Exercise(nome = "Rosca Alternada", categoriaId = categoryIds[3]),
                Exercise(nome = "Rosca Scott", categoriaId = categoryIds[3]),
                Exercise(nome = "Rosca Martelo", categoriaId = categoryIds[3]),
                Exercise(nome = "Rosca Concentrada", categoriaId = categoryIds[3]),
                Exercise(nome = "Rosca Inversa", categoriaId = categoryIds[3]),
                Exercise(nome = "Rosca com barra W", categoriaId = categoryIds[3]),
                Exercise(nome = "Rosca na Polia", categoriaId = categoryIds[3]),
                Exercise(nome = "Rosca Isolada", categoriaId = categoryIds[3]),

                // Tríceps - categoryIds[4]
                Exercise(nome = "Tríceps Testa", categoriaId = categoryIds[4]),
                Exercise(nome = "Tríceps Corda", categoriaId = categoryIds[4]),
                Exercise(nome = "Tríceps Francês", categoriaId = categoryIds[4]),
                Exercise(nome = "Tríceps com Halteres", categoriaId = categoryIds[4]),
                Exercise(nome = "Tríceps Polia", categoriaId = categoryIds[4]),
                Exercise(nome = "Tríceps Polia Inversa", categoriaId = categoryIds[4]),

                // Ombros - categoryIds[5]
                Exercise(nome = "Desenvolvimento com halteres", categoriaId = categoryIds[5]),
                Exercise(nome = "Elevação lateral", categoriaId = categoryIds[5]),
                Exercise(nome = "Elevação frontal", categoriaId = categoryIds[5]),
                Exercise(nome = "Crucifixo inverso", categoriaId = categoryIds[5]),
                Exercise(nome = "Desenvolvimento Arnold", categoriaId = categoryIds[5]),
                Exercise(nome = "Encolhimento", categoriaId = categoryIds[5]),
                Exercise(nome = "Elevação lateral inclinada", categoriaId = categoryIds[5]),
                Exercise(nome = "Manguito", categoriaId = categoryIds[5]),

                // Abdômen - categoryIds[6]
                Exercise(nome = "Abdominal infra", categoriaId = categoryIds[6]),
                Exercise(nome = "Prancha", categoriaId = categoryIds[6]),
                Exercise(nome = "Abdominal Máquina", categoriaId = categoryIds[6]),
                Exercise(nome = "Abdominal bicicleta", categoriaId = categoryIds[6]),
                Exercise(nome = "Abdominal no banco inclinado", categoriaId = categoryIds[6]),
            )

            // Insere todos os exercícios
            exerciseDao.insertAll(allExercises)


            val trainingDays = listOf(
                TrainingDay(dayOfWeek = "Segunda-feira"),
                TrainingDay(dayOfWeek = "Terça-feira"),
                TrainingDay(dayOfWeek = "Quarta-feira"),
                TrainingDay(dayOfWeek = "Quinta-feira")
            )
            trainingDay.insertAll(trainingDays)


            val segunda = trainingDay.getTrainingDays().first { it.dayOfWeek == "Segunda-feira" }
            val exercises = exerciseDao.getExercises()
            val supinoReto = exercises.first { it.nome == "Supino Reto halteres" }
            val crossRef = TrainingDayExerciseCrossRef(
                trainingDayId = segunda.trainingDayId,
                exerciseId = supinoReto.exerciseId
            )
            trainingDayExerciseCrossRef.insert(crossRef)

*/

        }

        setContent {
            val navController = rememberNavController()
            GymTrainingNavHost(
                navController = navController
            )
        }

    }
}
