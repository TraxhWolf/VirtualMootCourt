package com.example.virtualmootcourt.app

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import com.example.virtualmootcourt.navigation.Screen
import com.example.virtualmootcourt.navigation.VMCNavigation
import com.example.virtualmootcourt.ui.screens.ConsentAndSelectionScreen
import com.example.virtualmootcourt.ui.screens.EnterMootScreen
import com.example.virtualmootcourt.ui.screens.HomeScreen
import com.example.virtualmootcourt.ui.screens.LoginErrorScreen
import com.example.virtualmootcourt.ui.screens.LoginScreen
import com.example.virtualmootcourt.ui.screens.ProblemScreen
import com.example.virtualmootcourt.ui.screens.RulesScreen

@Composable
// main composable with all the navigation components
fun VirtualMootCourtApp() {
    Crossfade(targetState = VMCNavigation.currentScreen, label = "") { currentState ->
        when(currentState.value) {
            is Screen.Home -> {
                HomeScreen()
            }
            is Screen.Login -> {
                LoginScreen()
            }
            is Screen.LoginError -> {
                LoginErrorScreen()
            }
            is Screen.EnterMoot -> {
                EnterMootScreen()
            }
            is Screen.Rules -> {
                RulesScreen()
            }
            is Screen.Problem -> {
                ProblemScreen()
            }
            is Screen.ConsentAndSelection -> {
                ConsentAndSelectionScreen()
            }
        }
    }
}