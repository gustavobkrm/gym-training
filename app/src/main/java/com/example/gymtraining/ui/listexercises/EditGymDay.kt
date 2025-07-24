package com.example.gymtraining.ui.listexercises

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gymtraining.R
import kotlinx.coroutines.delay

@Composable
fun EditGymDay(state: EditGymDayUiState) {
    val balooFontFamily = FontFamily(
        Font(R.font.baloo, weight = FontWeight.Normal)
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(bottom = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Treinaremos o que?",
            fontFamily = balooFontFamily,
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.texto_principal),
            textAlign = TextAlign.Center,
            maxLines = 1
        )
    }
    AddNewGymTraining(
        onNavigate = state.onNavigateToAddNewExercise
    )

    /*if (!PossuiTreino(dayName))
    AddNewGymTraining(navController)
else
    LoadListaGymTraining()
*/
    //AddNewGymTraining()


}

@Composable
fun AddNewGymTraining(onNavigate: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.plus_square),
            contentDescription = "Botão adicionar exercício",
            modifier = Modifier
                .size(250.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(
                        color = Color(0xFF99E0E0),
                        bounded = true
                    )
                ) {
                    onNavigate()
                }
        )
    }
}
