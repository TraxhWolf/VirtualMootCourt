package com.example.virtualmootcourt.ui

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
import androidx.compose.ui.window.Dialog
import com.example.virtualmootcourt.R
import com.example.virtualmootcourt.ui.components.AppButton
import com.example.virtualmootcourt.ui.components.InputField
import com.example.virtualmootcourt.ui.components.NavHeader
import com.example.virtualmootcourt.ui.theme.VirtualMootCourtTheme

@Composable
//main render composable
fun ConsentAndSelectionScreen(
    modifier: Modifier = Modifier,
    //onSubmitButtonCLicked: () -> Unit
) {

    var emailJudge by remember { mutableStateOf("") } //judge email
    var emailPetitioner by remember { mutableStateOf("") } //advocate1(petitioner) email
    var emailRespondent by remember { mutableStateOf("") } //advocate2(respondent) email
    var daysRequired by remember { mutableStateOf("") } //no.of days needed 👍
    var dialogBox by remember { mutableStateOf(false) }

    when{
        dialogBox -> {
            ConfirmationDialog(
                onDismissRequest = { dialogBox = false }
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
                    Spacer(modifier = modifier.height(80.dp))
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
                            text = stringResource(R.string.consent_screen_header),
                            color = Color.White,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = modifier.height(30.dp))
                        Text(
                            text = stringResource(id = R.string.consent_text),
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
                            value = emailJudge,
                            change = { emailJudge = it }
                        )
                        Spacer(modifier = modifier.height(15.dp))
                        InputField( //CommonUI.kt function
                            text = stringResource(id = R.string.petitioner),
                            value = emailPetitioner,
                            change = { emailPetitioner = it }
                        )
                        Spacer(modifier = modifier.height(15.dp))
                        InputField( //CommonUI.kt function
                            text = stringResource(id = R.string.respondent),
                            value = emailRespondent,
                            change = { emailRespondent = it }
                        )
                        Spacer(modifier = modifier.height(15.dp))
                        InputField( //CommonUI.kt function
                            text = stringResource(id = R.string.days_for_preparation),
                            value = daysRequired,
                            change = { daysRequired = it }
                        )
                        Spacer(modifier = modifier.height(40.dp))
                        Row( //Button layout
                            modifier = modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            AppButton(
                                onClick = { dialogBox = !dialogBox },
                                text = stringResource(id = R.string.submit_button)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ConfirmationDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFF131D24),
                    shape = RoundedCornerShape(
                        size = 10.dp
                    )
                )
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "You have registered successfully.",
                color = Color.White
            )
            Spacer(modifier = modifier.height(20.dp))
            AppButton(onClick = { onDismissRequest() }, text = "DONE")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConsentAndSelectionPreview() {
    VirtualMootCourtTheme {
        ConsentAndSelectionScreen()
    }
}