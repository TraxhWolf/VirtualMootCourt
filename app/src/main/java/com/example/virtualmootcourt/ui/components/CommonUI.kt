package com.example.virtualmootcourt.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.virtualmootcourt.R
import com.example.virtualmootcourt.ui.theme.VirtualMootCourtTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
// The below composable is a function to collectively style and display the TextFields
//TextFields are used in 2 screens as of now(phase -1)
fun InputField(
    modifier: Modifier = Modifier,
    text: String,
    value: String, //For the value parameter of the TextField
    change: (String) -> Unit //For the onValueChange parameter of the TextField
) {
    Column {
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.padding(5.dp),
            fontSize = 17.sp
        )
        TextField(
            value = value,
            onValueChange = change,
            singleLine = true,
            modifier = modifier.height(55.dp),
            shape = RoundedCornerShape(25.dp),
            // Arguments passed below for the colors parameter is for achieving the custom style/design for the TextField
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                cursorColor = Color(0xFF131D24)
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInputField(
    modifier: Modifier = Modifier,
    text: String,
    value: String, //For the value parameter of the TextField
    change: (String) -> Unit //For the onValueChange parameter of the TextField
) {

    var passwordVisibility by rememberSaveable { mutableStateOf(false) }

    Column {
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.padding(5.dp),
            fontSize = 17.sp
        )
        TextField(
            value = value,
            onValueChange = change,
            singleLine = true,
            keyboardActions = KeyboardActions{defaultKeyboardAction(ImeAction.Done)},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val icon = if (passwordVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(
                        imageVector = icon,
                        contentDescription = stringResource(id = R.string.visibility_icon)
                    )
                }
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            modifier = modifier.height(55.dp),
            shape = RoundedCornerShape(25.dp),
            // Arguments passed below for the colors parameter is for achieving the custom style/design for the TextField
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                cursorColor = Color(0xFF131D24)
            )
        )
    }
}

@Composable
//The below composable is for the navigation bar.
// Navigation bar is used in 3 screens as of now(phase -1)
fun NavHeader(modifier: Modifier = Modifier) {
    Row( //primary layout container
        modifier = modifier
            .alpha(.85f)
            .height(85.dp)
            .fillMaxWidth()
            .background(Color(0xFF131D24))
            .padding(
                start = 20.dp,
                end = 20.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row( // row for only profile icon and username/ Register number(in most cases)
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon( // profile icon
                modifier = Modifier.size(size = 60.dp),
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = stringResource(R.string.default_profile_icon),
                tint = Color.White
            )
            Spacer(modifier = modifier.width(5.dp))
            Text( //the identifier- username/ register number to be displayed
                text = stringResource(R.string.username_or_register_number),
                color = Color.White
            )
        }
        Row {
            Icon( // sandwich menu icon
                modifier = Modifier.size(size = 60.dp),
                imageVector = Icons.Outlined.Menu,
                contentDescription = stringResource(R.string.menu_icon),
                tint = Color.White
            )
        }
    }
    Row( //This row is just for the bottom-border LOL
        modifier = modifier
            .height(1.dp)
            .fillMaxWidth()
            .background(Color.White)
    ) {}
}

@Composable
fun HomeButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String
) {
    Button( //login
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF131D24)),
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .width(280.dp)
            .height(40.dp)
    ) {
        Text(
            text = text,
            color = Color.White
        )
    }
}

@Composable
fun EntryButton(
    onClick: () -> Unit,
    text: String
) {
    Button(
        //login button into app
        // has two routes, either admin or the user(student)
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF91795E)),
        modifier = Modifier
            .height(50.dp)
            .width(120.dp),
        shape = RoundedCornerShape(25.dp)
    ) {
        Text(
            text = text,
            fontSize = 17.sp
        )
    }
}

@Composable
fun AppButton(
    onClick: () -> Unit,
    text: String
) {
    Button(// next button
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF91795E)),
        shape = RectangleShape,
        modifier = Modifier
            .height(35.dp)
            .width(95.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 17.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UIPreview() {
    VirtualMootCourtTheme {
    }
}