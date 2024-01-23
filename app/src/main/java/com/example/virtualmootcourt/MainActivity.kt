package com.example.virtualmootcourt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.virtualmootcourt.ui.ConsentAndSelectionScreen
import com.example.virtualmootcourt.ui.EnterMootScreen
import com.example.virtualmootcourt.ui.HomeScreen
import com.example.virtualmootcourt.ui.LoginScreen
import com.example.virtualmootcourt.ui.ProblemScreen
import com.example.virtualmootcourt.ui.RulesScreen
import com.example.virtualmootcourt.ui.theme.VirtualMootCourtTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VirtualMootCourtTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    App()
                }
            }
        }
    }
}

enum class AppScreens{
    //for naming the screens to give them an identifier
    // each property name explains itself to the corresponding screens
    Home,
    Login,
    EnterMoot,
    Rules,
    Problem,
    ConsentSelection
}

@Composable
// main composable with all the navigation components
fun App() {
    val navController = rememberNavController()
    //the NavHost and composable(s) responsible for the route and navigation specified
    //the navigation is made throughout the entire app through buttons at each screen
    //each of the composable below inside the NavHost specifies a route and calls the appropriate function from the screens to navigate to
    NavHost(
        navController = navController,
        startDestination = AppScreens.Home.name
    ) {
        composable(
            route = AppScreens.Home.name
        ) {
            HomeScreen(
                onLoginButtonClicked = { navController.navigate(AppScreens.Login.name) },
                onEnterMootButtonClicked = { navController.navigate(AppScreens.EnterMoot.name) }
            )
        }
        composable(
            route = AppScreens.Login.name
        ) {
            LoginScreen (
                onLoginButtonClicked = { navController.navigate(AppScreens.Rules.name) }
            )
        }
        composable(
            route = AppScreens.EnterMoot.name
        ) {
            EnterMootScreen()
        }
        composable(
            route = AppScreens.Rules.name
        ) {
            RulesScreen (
                onNextButtonClicked = { navController.navigate(AppScreens.Problem.name) }
            )
        }
        composable(
            route = AppScreens.Problem.name
        ) {
            ProblemScreen (
                onNextButtonClicked = { navController.navigate(AppScreens.ConsentSelection.name) }
            )
        }
        composable(
            route = AppScreens.ConsentSelection.name
        ) {
            ConsentAndSelectionScreen ()
        }
    }
}