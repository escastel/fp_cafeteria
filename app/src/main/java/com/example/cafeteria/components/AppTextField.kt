package com.example.cafeteria.components

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cafeteria.R
import com.example.cafeteria.ui.theme.CafeteriaTheme

@Composable
fun AppTextField(
    username: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = username,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        label = {
            Text(text = stringResource(R.string.tf_label))
        },
        placeholder = {
            Text(text = stringResource(R.string.tf_placeholder))
        },
    )
}

@Preview
@Composable
fun AppTextFieldPreview(){
    CafeteriaTheme { 
        AppTextField(
            username = "",
            onValueChange = {}
        )
    }
}