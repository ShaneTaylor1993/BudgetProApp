package com.example.budgetpro.ui

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.budgetpro.routes.Routes.Home
import com.example.budgetpro.routes.Routes.Stats
import screens.HomeScreen
import screens.StatsScreen
import viewmodel.BudgetViewModel
import com.example.budgetpro.R

@Composable
fun BudgetApp() {
    val navController = rememberNavController()
    val vm: BudgetViewModel = viewModel()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(red = 1, green = 46, blue = 81),
        bottomBar = {
            BudgetBottomAppBar(
                navController
            )
        }
    ){ innerPadding ->
        NavHost(navController = navController, startDestination = Home, enterTransition = {
            fadeIn(animationSpec = tween(0))
        },
            exitTransition = {fadeOut(animationSpec = tween(0))}) {
            composable<Home> {
                HomeScreen(vm)
            }
            composable<Stats> {
                StatsScreen()
            }
        }
        Spacer(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun BudgetBottomAppBar(navController: NavController) {
    BottomAppBar(
        modifier = Modifier.fillMaxWidth().height(60.dp),
        containerColor = Color(red = 111, green = 138, blue = 183),
        windowInsets = WindowInsets(0)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            IconButton(
                onClick = { navController.navigate(Home) }
            ) {
                Icon(
                    modifier = Modifier.size(50.dp),
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Home"
                )
            }
            IconButton(
                onClick = { navController.navigate(Stats) }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.stacks),
                    contentDescription = "Stacks icon",
                    modifier = Modifier.size(50.dp)
                )
            }
        }

    }
}
