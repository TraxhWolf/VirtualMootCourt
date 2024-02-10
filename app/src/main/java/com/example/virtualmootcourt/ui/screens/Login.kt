package com.example.virtualmootcourt.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.virtualmootcourt.R
import com.example.virtualmootcourt.data.login.LoginUIEvent
import com.example.virtualmootcourt.data.login.LoginViewModel
import com.example.virtualmootcourt.navigation.Screen
import com.example.virtualmootcourt.navigation.SystemBackButtonHandler
import com.example.virtualmootcourt.navigation.VMCNavigation
import com.example.virtualmootcourt.ui.components.EntryButton
import com.example.virtualmootcourt.ui.components.InputField
import com.example.virtualmootcourt.ui.components.PasswordInputField
import com.example.virtualmootcourt.ui.theme.VirtualMootCourtTheme

//Yeah the below composable is for the main rendering of this login page
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    loginViewModel: LoginViewModel = viewModel()
) {
    Box( //Box is chosen to stack components above sathyabama image
        modifier = modifier
            .fillMaxSize()
    ) {
        Image( //yeah same goofy sathyabama background image
            painter = painterResource(id = R.drawable.homescreenbg),
            contentDescription = stringResource(R.string.home_screen_bg_image),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            alpha = 0.7f
        )
        Column( //invisible column that is stacked over the image to center the container
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column( //the said container
                modifier = modifier
                    .background(Color(0xFF131D24), shape = CircleShape)
                    .size(
                        width = 450.dp,
                        height = 400.dp
                    )
                    .padding(
                        start = 69.dp,
                        end = 69.dp,
                        top = 10.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                InputField( //CommonUI.kt function
                    text = stringResource(id = R.string.credential_label_2),
                    change = { loginViewModel.onEvent(LoginUIEvent.RegisterNumberChanged(it)) }
                )
                PasswordInputField( //CommonUI.kt function
                    text = stringResource(id = R.string.password_label),
                    change = { loginViewModel.onEvent(LoginUIEvent.PasswordChanged(it)) }
                )
                Spacer(modifier = modifier.height(35.dp))
                EntryButton(
                    onClick = { loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked) },
                    text = stringResource(id = R.string.login_button)
                )
            }
        }
        /*if (loginViewModel.loginInProgress.value) {
            Column(
                modifier.fillMaxSize().background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LinearProgressIndicator(
                    color = Color.Black
                )
            }
        }*/
    }
    SystemBackButtonHandler { VMCNavigation.navigateTo(Screen.Home) }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    VirtualMootCourtTheme {
        LoginScreen()
    }
}