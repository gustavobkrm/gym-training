package com.example.gymtraining.ui.newexercise

import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
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
import kotlin.math.log

@Composable
fun AddNewExercises(
    state: AddNewExerciseUiState,
    onClickDropDown: () -> Unit = {},
    onClickSalvar: () -> Unit = {}
) {
    val balooFontFamily = FontFamily(
        Font(R.font.baloo, weight = FontWeight.Normal)
    )

    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        // Título centralizado
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Adicionar Exercício",
                fontFamily = balooFontFamily,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.texto_principal),
                textAlign = TextAlign.Center,
                maxLines = 1
            )
        }

        // Espaço entre o título e o dropdown
        Spacer(modifier = Modifier.height(5.dp))

        // Dropdown estilizado
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF99E0E0), shape = RoundedCornerShape(15.dp))
                .padding(horizontal = 15.dp, vertical = 8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(20.dp))
                    .clickable (
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { expanded = !expanded }
                    .padding(12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Selecione uma categoria",
                        modifier = Modifier.weight(1f),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = balooFontFamily,
                        color = Color(0xFFFF6600)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.arrow_down),
                        contentDescription = null,
                        modifier = Modifier
                            .size(64.dp)
                            .rotate(if (expanded) 0f else 270f)
                    )
                }
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                DropdownMenuItem(
                    text = {
                        Text(
                            "Opção 1",
                            fontWeight = FontWeight.Bold,
                            fontFamily = balooFontFamily,
                            fontSize = 30.sp,
                            color = Color(0xFFFF6600)
                        )
                    },
                    onClick = {
                        expanded = false
                        onClickDropDown()
                    }
                )
                DropdownMenuItem(
                    text = {
                        Text(
                            "Opção 2",
                            fontWeight = FontWeight.Bold,
                            fontFamily = balooFontFamily,
                            fontSize = 30.sp,
                            color = Color(0xFFFF6600)
                        )
                    },
                    onClick = {
                        expanded = false
                        onClickDropDown()
                    }
                )
            }
        }
    }

    Log.d("UI", "AddNewExercises: entrou")
}
