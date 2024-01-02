package com.example.virtualmootcourt.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.virtualmootcourt.R
import com.example.virtualmootcourt.ui.components.NavHeader
import com.example.virtualmootcourt.ui.theme.VirtualMootCourtTheme

@Composable
fun RulesScreen(
    modifier: Modifier = Modifier,
    onNextButtonClicked: () -> Unit
) {
    Box{ //Box to stack components over the Moot Court Background Image
        Image(//The said Moot Court Background Image
            painter = painterResource(id = R.drawable.mainappbg),
            contentDescription = stringResource(R.string.main_app_bg_image),
            modifier = modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column {// yep, that's it to contain rest of the stuff
            NavHeader() //CommonUI.kt function
            Spacer(modifier = modifier.height(70.dp))
            Box {//Box to stack the invisible column over the container column
                Column( //This column is this time just for the border- da invisible column
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
                Column( //actual content container
                    modifier = modifier
                        .fillMaxSize()
                        .background(
                            Color(0xFF131D24).copy(alpha = 0.7f), //thanks to stackOverFlow fr
                            shape = RoundedCornerShape(
                                topStart = 75.dp,
                                topEnd = 75.dp
                            )
                        )
                        .padding(
                            start = 25.dp,
                            end = 25.dp
                        ),
                ) {
                    Spacer(modifier = modifier.height(80.dp))
                    Column( //nah this the actual container--to achieve inbound scrolling this was nested
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(
                                bottom = 20.dp
                            )
                            .verticalScroll(ScrollState(0)) //the scroll factor
                            .background(
                                color = Color.Transparent,
                                shape = RoundedCornerShape(
                                    topStart = 75.dp,
                                    topEnd = 75.dp
                                )
                            )
                    ) {
                        Text( //heading
                            text = stringResource(R.string.rules_screen_header),
                            color = Color.White,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = modifier.height(30.dp))
                        Text( //rules or smth
                            text = stringResource(R.string.lorem_text_dummy_1) + "\n" + stringResource(R.string.lorem_text_dummy_2) + "\n" + stringResource(
                                R.string.lorem_text_dummy_3
                            ),
                            color = Color.White,
                            textAlign = TextAlign.Justify
                        )
                        Spacer(modifier = modifier.height(40.dp))
                        Row( //this time used row for button lol 💀
                            modifier = modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Button(// next button
                                onClick = onNextButtonClicked,
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF91795E)),
                                shape = RectangleShape,
                                modifier = Modifier
                                    .height(35.dp)
                                    .width(95.dp),
                                contentPadding = PaddingValues(0.dp)
                            ) {
                                Text(
                                    text = stringResource(R.string.next_button),
                                    color = Color.White,
                                    fontSize = 17.sp,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RulesPreview() {
    VirtualMootCourtTheme {
        RulesScreen(
            onNextButtonClicked = {}
        )
    }
}