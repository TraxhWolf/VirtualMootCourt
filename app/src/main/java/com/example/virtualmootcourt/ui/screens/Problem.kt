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
import com.example.virtualmootcourt.R
import com.example.virtualmootcourt.navigation.Screen
import com.example.virtualmootcourt.navigation.SystemBackButtonHandler
import com.example.virtualmootcourt.navigation.VMCNavigation
import com.example.virtualmootcourt.ui.components.AppButton
import com.example.virtualmootcourt.ui.components.NavHeader
import com.example.virtualmootcourt.ui.theme.VirtualMootCourtTheme

@Composable
//Below composable the main render for this screen
fun ProblemScreen(
    modifier: Modifier = Modifier
) {
    Box{//Box to stack again
        Image(//Moot Image
            painter = painterResource(id = R.drawable.mainappbg),
            contentDescription = stringResource(R.string.main_app_bg_image),
            modifier = modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column {//mini container that is stacked on the image
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
                Column( //actual container
                    modifier = modifier
                        .fillMaxSize()
                        .background(
                            Color(0xFF131D24).copy(alpha = 0.7f), //stackOverFlow 🛐
                            shape = RoundedCornerShape(
                                topStart = 75.dp,
                                topEnd = 75.dp
                            )
                        )
                        .padding(
                            start = 25.dp,
                            end = 25.dp
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Spacer(modifier = modifier.height(40.dp))
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Problem Statement",
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = modifier.height(40.dp))
                    Column( //da actual container
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
                            )
                    ) {
                        Text( //head text one
                            text = stringResource(id = R.string.main_problem_header),
                            color = Color.White,
                            fontSize = 20.sp,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        Spacer(modifier = modifier.height(20.dp))
                        Text( // head text two
                            text = stringResource(id = R.string.course_specifics),
                            color = Color.White,
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            fontSize = 18.sp
                        )
                        Spacer(modifier = modifier.height(30.dp))
                        Text( //long ahh static moot problem text
                            text =
                            stringResource(id = R.string.p1) + "\n" + "\n" +
                                    stringResource(id = R.string.p2) + "\n" + "\n" +
                                    stringResource(id = R.string.p3) + "\n" + "\n" +
                                    stringResource(id = R.string.p4) + "\n" + "\n" +
                                    stringResource(id = R.string.p5) + "\n" + "\n" +
                                    stringResource(id = R.string.p6) + "\n" + "\n" +
                                    stringResource(id = R.string.p7) + "\n" + "\n" +
                                    stringResource(id = R.string.p8) + "\n" + "\n" +
                                    stringResource(id = R.string.p9) + "\n" + "\n" +
                                    stringResource(id = R.string.p10) + "\n" + "\n" +
                                    stringResource(id = R.string.p11) + "\n" + "\n" +
                                    stringResource(id = R.string.p12) + "\n" + "\n" +
                                    stringResource(id = R.string.p13) + "\n" + "\n" +
                                    stringResource(id = R.string.p14) + "\n" + "\n" +
                                    stringResource(id = R.string.p15) + "\n" + "\n" +
                                    stringResource(id = R.string.p16) + "\n" + "\n" +
                                    stringResource(id = R.string.p17) + "\n" + "\n" +
                                    stringResource(id = R.string.p18) + "\n" + "\n" +
                                    stringResource(id = R.string.p19) + "\n" + "\n" +
                                    stringResource(id = R.string.p20),
                            color = Color.White,
                            textAlign = TextAlign.Justify
                        )
                        Spacer(modifier = modifier.height(40.dp))
                        Row( //Button layout
                            modifier = modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            AppButton(
                                onClick = { VMCNavigation.navigateTo(Screen.ConsentAndSelection) },
                                text = stringResource(id = R.string.next_button)
                            )
                        }
                    }
                }
            }
        }
    }
    SystemBackButtonHandler { VMCNavigation.navigateTo(Screen.Rules) }
}

@Preview(showBackground = true)
@Composable
fun ProblemPreview() {
    VirtualMootCourtTheme {
        ProblemScreen()
    }
}