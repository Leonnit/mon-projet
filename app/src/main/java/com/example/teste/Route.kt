package com.example.teste

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.teste.viewmodel.UserViewModel
import com.example.teste.ui.screen.HomeScreen
import com.example.teste.ui.screen.SettingScreen

@Composable
fun AppRoute() {
    var navController = rememberNavController()
    NavHost(navController = navController, startDestination = "HomeScreen", builder = {
        composable("HomeScreen") {
            HomeScreen(navController)
        }
        composable("SettingScreen") {
            SettingScreen(navController)
        }
    })

}