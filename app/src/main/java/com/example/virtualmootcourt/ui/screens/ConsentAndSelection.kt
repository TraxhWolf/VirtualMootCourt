package com.example.virtualmootcourt.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.virtualmootcourt.R
import com.example.virtualmootcourt.data.consentAndSelection.CasUIEvent
import com.example.virtualmootcourt.data.consentAndSelection.CasViewModel
import com.example.virtualmootcourt.navigation.Screen
import com.example.virtualmootcourt.navigation.SystemBackButtonHandler
import com.example.virtualmootcourt.navigation.VMCNavigation
import com.example.virtualmootcourt.ui.components.AppButton
import com.example.virtualmootcourt.ui.components.ConfirmationDialog
import com.example.virtualmootcourt.ui.components.FinalInputField
import com.example.virtualmootcourt.ui.components.InputField
import com.example.virtualmootcourt.ui.components.NavHeader
import com.example.virtualmootcourt.ui.theme.VirtualMootCourtTheme

@Composable
//main render composable
fun ConsentAndSelectionScreen(
    modifier: Modifier = Modifier,
    casViewModel: CasViewModel = viewModel()
) {
    var dialogBox by remember { mutableStateOf(false) }
    when{
        dialogBox -> {
            ConfirmationDialog(
                onDismissRequest = { dialogBox = false },
                text = "You have registered successfully.",
                buttonText = "DONE"
            )
        }
    }
    Box{//box to stack
        Image(// moot image
            painter = painterResource(id = R.drawable.mainappbg),
            contentDescription = stringResource(R.string.main_app_bg_image),
            modifier = modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column {//stacked container
            NavHeader() //CommonUI.kt function
            Spacer(modifier = modifier.height(70.dp))
            Box {
                Column( //This column is this time just for the border LOL
                    modifier = modifier
                        .fillMaxSize()
                        .background(
                            Color.Transparent,
                            shape = RoundedCornerShape(
                                topStart = 75.dp,
                                topEnd = 75.dp
                            )
                        )
                        .border(
                            width = 1.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(
                                topStart = 75.dp,
                                topEnd = 75.dp,
                                bottomEnd = 0.dp,
                                bottomStart = 0.dp
                            )
                        )
                ) {}
                Column(//actual container
                    modifier = modifier
                        .fillMaxSize()
                        .background(
                            Color(0xFF131D24).copy(alpha = 0.7f), //stackOverFlow 😩🤌
                            shape = RoundedCornerShape(
                                topStart = 75.dp,
                                topEnd = 75.dp
                            )
                        )
                        .padding(
                            start = 25.dp,
                            end = 25.dp
                        )
                ) {
                    Spacer(modifier = modifier.height(40.dp))
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(id = R.string.consent_screen_header),
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = modifier.height(40.dp))
                    Column( //actual container
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(
                                bottom = 20.dp
                            )
                            .verticalScroll(ScrollState(0)) //scroll factor
                            .background(
                                color = Color.Transparent,
                                shape = RoundedCornerShape(
                                    topStart = 75.dp,
                                    topEnd = 75.dp
                                )
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "I have confirmed my participation in this moot session and hereby provide my details for the same.",
                            color = Color.White,
                            textAlign = TextAlign.Justify
                        )
                        Spacer(modifier = modifier.height(40.dp))
                        Text(
                            text = stringResource(R.string.emails_header),
                            color = Color.White,
                            fontSize = 20.sp,
                        )
                        Spacer(modifier = modifier.height(15.dp))
                        InputField( //CommonUI.kt function
                            text = stringResource(id = R.string.judge),
                            change = { casViewModel.onEvent(CasUIEvent.JudgeEmailEntered(it)) }
                        )
                        Spacer(modifier = modifier.height(15.dp))
                        InputField( //CommonUI.kt function
                            text = stringResource(id = R.string.petitioner),
                            change = { casViewModel.onEvent(CasUIEvent.PetitionerEmailEntered(it)) }
                        )
                        Spacer(modifier = modifier.height(15.dp))
                        InputField( //CommonUI.kt function
                            text = stringResource(id = R.string.respondent),
                            change = { casViewModel.onEvent(CasUIEvent.RespondentEmailEntered(it)) }
                        )
                        Spacer(modifier = modifier.height(15.dp))
                        FinalInputField( //CommonUI.kt function
                            text = stringResource(id = R.string.days_for_preparation),
                            change = { casViewModel.onEvent(CasUIEvent.NoOfDaysEntered(it)) }
                        )
                        Spacer(modifier = modifier.height(40.dp))
                        Row( //Button layout
                            modifier = modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            AppButton(
                                onClick = {
                                    dialogBox = !dialogBox
                                    casViewModel.onEvent(CasUIEvent.CASSubmitButtonClicked)
                                          },
                                text = stringResource(id = R.string.submit_button)
                            )
                        }
                    }
                }
            }
        }
    }
    SystemBackButtonHandler { VMCNavigation.navigateTo(Screen.Problem) }
}

@Preview(showBackground = true)
@Composable
fun ConsentAndSelectionPreview() {
    VirtualMootCourtTheme {
        ConsentAndSelectionScreen()
    }
}