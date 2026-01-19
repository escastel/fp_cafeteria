package com.example.cafeteria.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cafeteria.R
import com.example.cafeteria.components.AppButton
import com.example.cafeteria.components.AppCard
import com.example.cafeteria.components.AppSelector
import com.example.cafeteria.components.AppTextField
import com.example.cafeteria.ui.theme.CafeteriaTheme

@Composable
fun AppScreen(modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var amount by remember { mutableIntStateOf(1) }
    var option by remember { mutableStateOf("Jamón") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.img_header),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.title_app),
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        AppTextField(username = username) { username = it }

        Spacer(modifier = Modifier.height(24.dp))

        AppSelector(option = option, onOptionSelected = { option = it})

        Spacer(modifier = Modifier.height(24.dp))

        AppCard(image = R.drawable.img_jamon, product = option, price = "20")

        Spacer(modifier = Modifier.height(24.dp))

        AppButton(text = stringResource(R.string.btn_confirm)) {}
    }
}

@Preview(showBackground = true)
@Composable
fun AppScreenPreview(){
    CafeteriaTheme {
        AppScreen()
    }
}

