package com.example.virtualmootcourt.ui

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.virtualmootcourt.R
import com.example.virtualmootcourt.ui.components.InputField
import com.example.virtualmootcourt.ui.theme.VirtualMootCourtTheme

//Yeah the below composable is for the main rendering of this login page
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onLoginButtonClicked: () -> Unit
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
                InputFields() //function call!
                Spacer(modifier = modifier.height(35.dp))
                Column {// tbh coulda went for any other container too but idk why column
                    Button(
                        //login button into app
                        // has two routes, either admin or the user(student)
                        onClick = onLoginButtonClicked,
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF91795E)),
                        modifier = Modifier
                            .height(50.dp)
                            .width(120.dp),
                        shape = RoundedCornerShape(25.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.login_button),
                            fontSize = 17.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
//yeah this the composable function to be called, has the label and textfield
fun InputFields(modifier: Modifier = Modifier) {

    var credential by remember { mutableStateOf("") } //uh credential- either username/register no.
    var password by remember { mutableStateOf("") } //password fr

    Column(// main column to contain both
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {//column to container label and textfield
            Text(
                text = stringResource(R.string.credential_label),
                color = Color.White,
                modifier = Modifier.padding(5.dp),
                fontSize = 17.sp
            )
            InputField( //CommonUI.kt function
                value = credential,
                change = { credential = it}
            )
        }
        Spacer(modifier = modifier.height(20.dp))
        Column {// second column to contain label and textfield
            Text(
                text = stringResource(R.string.password_label),
                color = Color.White,
                modifier = Modifier.padding(5.dp),
                fontSize = 17.sp
            )
            InputField( //CommonUI.kt function
                value = password,
                change = { password = it }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    VirtualMootCourtTheme {
        LoginScreen(
            onLoginButtonClicked = {}
        )
    }
}
