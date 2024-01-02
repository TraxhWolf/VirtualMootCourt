package com.example.virtualmootcourt.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.virtualmootcourt.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
// The below composable is a function to collectively style and display the TextFields
//TextFields are used in 2 screens as of now(phase -1)
fun InputField(
    modifier: Modifier = Modifier,
    value: String, //For the value parameter of the TextField
    change: (String) -> Unit //For the onValueChange parameter of the TextField
) {
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