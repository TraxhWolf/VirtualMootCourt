package com.example.virtualmootcourt.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen{
    object Home : Screen()
    object Login : Screen()
    object LoginError : Screen()
    object EnterMoot : Screen()
    object Rules : Screen()
    object Problem : Screen()
    object ConsentAndSelection : Screen()
}

object VMCNavigation {
    val currentScreen : MutableState<Screen> = mutableStateOf(Screen.Home)
    fun navigateTo(destination: Screen) {
        currentScreen.value = destination
    }
}
