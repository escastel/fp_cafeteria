package com.example.cafeteria.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cafeteria.R
import com.example.cafeteria.data.ItemRepository
import com.example.cafeteria.model.ItemUiModel
import com.example.cafeteria.ui.components.AppAmountSelector
import com.example.cafeteria.ui.components.AppButton
import com.example.cafeteria.ui.components.AppCard
import com.example.cafeteria.ui.components.AppHeader
import com.example.cafeteria.ui.components.AppProductSelector
import com.example.cafeteria.ui.components.AppTextField
import com.example.cafeteria.ui.theme.CafeteriaTheme

@Composable
fun AppScreen(modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var amount by remember { mutableIntStateOf(0) }
    var option by remember { mutableStateOf("Jamón") }
    var orderList by remember { mutableStateOf(listOf<ItemUiModel>()) }
    var showDialog by remember { mutableStateOf(false) }
    val productImages = ItemRepository().getProductImagesData()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        AppHeader()

        Spacer(modifier = Modifier.height(24.dp))

        AppTextField(username = username) { username = it }

        Spacer(modifier = Modifier.height(24.dp))

        AppProductSelector(option = option, onOptionSelected = { option = it})

        Spacer(modifier = Modifier.height(24.dp))

        AppAmountSelector(amount = amount, onAmountChange = { amount = it })

        Spacer(modifier = Modifier.height(24.dp))

        AppButton(text = "Añadir pedido (" + (amount * 10).toString() + "€)") {
            if (amount > 0){
                orderList = orderList + ItemUiModel(
                    drawable = productImages.getValue(option),
                    product = option,
                    price = amount * 10,
                    amount = amount
                )
                amount = 0
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Divider()

        Text(
            text = "Lista de pedidos (" + orderList.size + ") para $username",
            color = Color.Green,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(orderList) { order ->
                AppCard(
                    image = order.drawable,
                    product = order.product,
                    price = order.price.toString(),
                    amount = order.amount
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        AppButton(text = stringResource(R.string.btn_confirm)) {
            if (orderList.isNotEmpty() && username.isNotEmpty())
                showDialog = true
        }
    }

    if (showDialog){ }
}

@Preview(showBackground = true)
@Composable
fun AppScreenPreview(){
    CafeteriaTheme {
        AppScreen()
    }
}

