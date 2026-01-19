package com.example.cafeteria.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cafeteria.R
import com.example.cafeteria.ui.theme.CafeteriaTheme

@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit
) {
    Button(modifier = Modifier.fillMaxWidth(), onClick = onClick) {
        Text(text = text)
    }
}

@Preview(widthDp = 320)
@Composable
fun AppButtonPreview(){
    CafeteriaTheme {
        AppButton(
            text = stringResource(R.string.btn_confirm),
            onClick = {}
        )
    }
}

