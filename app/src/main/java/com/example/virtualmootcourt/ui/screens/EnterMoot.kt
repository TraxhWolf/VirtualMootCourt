package com.example.virtualmootcourt.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.virtualmootcourt.R
import com.example.virtualmootcourt.navigation.Screen
import com.example.virtualmootcourt.navigation.SystemBackButtonHandler
import com.example.virtualmootcourt.navigation.VMCNavigation
import com.example.virtualmootcourt.ui.components.EntryButton
import com.example.virtualmootcourt.ui.components.InputField
import com.example.virtualmootcourt.ui.theme.VirtualMootCourtTheme

@Composable
fun EnterMootScreen(modifier: Modifier = Modifier) {

    var mootCode by rememberSaveable { mutableStateOf("") } //moot code from email or smth .

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
                Column(// main column
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    InputField( //CommonUI.kt function
                        text = stringResource(id = R.string.user_code_label),
                        change = { mootCode = it}
                    )
                }
                Spacer(modifier = modifier.height(35.dp))
                EntryButton(
                    onClick = { },
                    text = stringResource(id = R.string.enter_button)
                )
            }
        }
    }
    SystemBackButtonHandler { VMCNavigation.navigateTo(Screen.Home) }
}

@Preview(showBackground = true)
@Composable
fun EnterMootPreview() {
    VirtualMootCourtTheme {
        EnterMootScreen()
    }
}