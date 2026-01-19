package com.example.cafeteria.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cafeteria.ui.theme.CafeteriaTheme

@Composable
fun AppAmountSelector(
    amount: Int,
    onAmountChange: (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ){
        OutlinedButton(
            modifier = Modifier.size(width = 64.dp, height = 40.dp),
            onClick = { if (amount > 0) onAmountChange(amount - 1) }
        ) {
            Text(text = "-")
        }
        Text(
            text = "$amount",
            modifier = Modifier.padding(horizontal = 20.dp),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        OutlinedButton(
            modifier = Modifier.size(width = 64.dp, height = 40.dp),
            onClick = { onAmountChange(amount + 1) }
        ) {
            Text(text = "+")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppAmountSelectorPreview(){
    CafeteriaTheme {
        AppAmountSelector(
            amount = 1,
            onAmountChange = {}
        )
    }
}