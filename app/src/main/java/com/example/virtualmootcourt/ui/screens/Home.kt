package com.example.virtualmootcourt.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.virtualmootcourt.R
import com.example.virtualmootcourt.navigation.Screen
import com.example.virtualmootcourt.navigation.VMCNavigation
import com.example.virtualmootcourt.ui.components.HomeButton
import com.example.virtualmootcourt.ui.theme.VirtualMootCourtTheme

@Composable
// Below composable is the main function that renders the Home screen
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Box( //Box to stack the contents above the college image
        modifier = modifier.fillMaxSize(),
    ){
        Image( // the said background image
            painter = painterResource(id = R.drawable.homescreenbg),
            contentDescription = stringResource(R.string.home_screen_bg_image),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            alpha = 0.7f
        )
        Column( // Primary column for arranging the logo and the other container
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row( // coulda used any layout but yeah row better fr, idk why duh its just better lol
                modifier = modifier.fillMaxWidth()
            ) {
                Image( //mid ahh sathyabama logo
                    painter = painterResource(id = R.drawable.sist_logo_ar_main),
                    contentDescription = stringResource(R.string.sist_logo),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(85.dp)
                        .padding(
                            top = 5.dp
                        )
                )
            }
            Spacer(modifier = modifier.height(250.dp))
            Column( //container that contains the buttons
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                HomeButton(
                    onClick = { VMCNavigation.navigateTo(Screen.Login) },
                    text = stringResource(id = R.string.login_button)
                )
                Spacer(modifier = modifier.height(30.dp))
                HomeButton(
                    onClick = { VMCNavigation.navigateTo(Screen.EnterMoot) },
                    text = stringResource(id = R.string.enter_moot_button)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    VirtualMootCourtTheme {
        HomeScreen()
    }
}