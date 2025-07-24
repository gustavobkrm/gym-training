package com.example.gymtraining

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.gymtraining.data.Category
import com.example.gymtraining.database.GymTrainingDatabase
import com.example.gymtraining.ui.theme.GymTrainingTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val categoryDao = GymTrainingDatabase.getDatabase(this).categoryDao()

        CoroutineScope(IO).launch{
            //categoryDao.insert(Category(nome = "Peito"))
            val buscaTodos = categoryDao.getCategories()
            Log.i("onCreate", "onCreate: $buscaTodos")
        }

        setContent {
            MainScreen()
        }

    }
}
