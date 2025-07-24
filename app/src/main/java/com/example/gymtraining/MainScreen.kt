package com.example.gymtraining

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.NavType

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home",
        enterTransition = { fadeIn(animationSpec = tween(500)) + slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left, tween(500))},
        exitTransition = { fadeOut(animationSpec = tween(500)) + slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left, tween(500))},
        popEnterTransition = { fadeIn(animationSpec = tween(500)) + slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right, tween(500))},
        popExitTransition = { fadeOut(animationSpec = tween(500)) + slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right, tween(500))}
    ) {
        composable("home") {
            MainContent(navController = navController)
        }

        composable(
            "edit_day/{dayName}",
            arguments = listOf(navArgument("dayName") { type = NavType.StringType })
        ) { backStackEntry ->
            val dayName = backStackEntry.arguments?.getString("dayName") ?: "Desconhecido"
            EditGymDay(dayName = dayName, navController = navController)
        }
        composable("add_new_exercise") {
            AddNewExercises(navController)
        }
    }
}

@Composable
fun ShapeableImage(
    resId: Int,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = resId),
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .border(
                width = 4.dp,
                color = colorResource(id = R.color.borda_avatar),
                shape = RoundedCornerShape(50)
            )
    )
}

@Composable
fun MainContent(navController: NavHostController) {

    val balooFontFamily = FontFamily(
        Font(R.font.baloo, weight = FontWeight.Normal)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            ShapeableImage(
                resId = R.drawable.avatar_esquerda,
                contentDescription = "Avatar Esquerda",
                modifier = Modifier
                    .size(87.dp)
                    .padding(2.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Treino do dia",
                modifier = Modifier
                    .weight(1f)
                    .height(60.dp),
                fontFamily = balooFontFamily,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.texto_principal),
                textAlign = TextAlign.Center,
                maxLines = 1
            )

            Spacer(modifier = Modifier.width(8.dp))

            ShapeableImage(
                resId = R.drawable.avatar_direita,
                contentDescription = "Avatar Direita",
                modifier = Modifier
                    .size(87.dp)
                    .padding(2.dp)
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 16.dp)

        ) {
            DayItem(dayName = "Segunda-feira", navController = navController)
            Spacer(modifier = Modifier.height(25.dp))
            DayItem(dayName = "Terça-feira", navController = navController)
            Spacer(modifier = Modifier.height(25.dp))
            DayItem(dayName = "Quarta-feira", navController = navController)
            Spacer(modifier = Modifier.height(25.dp))
            DayItem(dayName = "Quinta-feira", navController = navController)
        }
    }
}
@Composable
fun DayItem(
    dayName: String,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(
                    color = Color(0xFFFF6600),
                    bounded = true
                )
            )
            {
                val encodedDay = java.net.URLEncoder.encode(dayName, "UTF-8")
                navController.navigate("edit_day/$encodedDay")
            }
            .background(
                color = Color(0xFF99E0E0),
                shape = RoundedCornerShape(15.dp)
            )
            .padding(horizontal = 15.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(20.dp))
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = dayName,
                modifier = Modifier.weight(1f),
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.baloo)),
                color = Color(0xFFFF6600)
            )
            Image(
                painter = painterResource(id = R.drawable.arrow_left),
                contentDescription = null,
                modifier = Modifier.size(64.dp)
            )
        }
    }
}