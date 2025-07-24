package com.example.gymtraining
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun EditGymDay(dayName: String, navController: NavController) {
    MainText()
    /*if (!PossuiTreino(dayName))
        AddNewGymTraining(navController)
    else
        LoadListaGymTraining()
*/
    AddNewGymTraining(navController)

}

@Composable
fun AddNewGymTraining(navController: NavController){
    var expanded by remember { mutableStateOf(false) }

    val size by animateDpAsState(
        targetValue = if (expanded) 1000.dp else 250.dp,
        animationSpec = tween(durationMillis = 500)
    )
    val alpha by animateFloatAsState(
        targetValue = if (expanded) 0f else 1f,
        animationSpec = tween(durationMillis = 500)
    )
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .clickable(
                    enabled = !expanded,
                    interactionSource = interactionSource,
                    indication = rememberRipple(color = Color(0xFF99E0E0),
                    bounded = true
                )
                ) {
                    expanded = true
                }
                .graphicsLayer {
                    this.alpha = alpha
                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.plus_square),
                contentDescription = "Botão add",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
    if (expanded) {
        LaunchedEffect(Unit) {
            delay(100)
            navController.navigate("add_new_exercise")
        }
    }
}

@Composable
fun MainText(){
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
}