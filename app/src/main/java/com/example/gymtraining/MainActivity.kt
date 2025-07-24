package com.example.gymtraining

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
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

        /*val categoryDao = GymTrainingDatabase.getDatabase(this).categoryDao()

        CoroutineScope(IO).launch{
            //categoryDao.insert(Category(nome = "Peito"))
            val buscaTodos = categoryDao.getCategories()
            Log.i("onCreate", "onCreate: $buscaTodos")


        }*/

        setContent {
            val navController = rememberNavController()
            GymTrainingNavHost(
                navController = navController
            )
        }

    }
}
