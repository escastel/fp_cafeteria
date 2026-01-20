package com.example.cafeteria.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cafeteria.R
import com.example.cafeteria.ui.components.AppAmountSelector
import com.example.cafeteria.ui.components.AppButton
import com.example.cafeteria.ui.components.AppCard
import com.example.cafeteria.ui.components.AppConfirmDialog
import com.example.cafeteria.ui.components.AppErrorDialog
import com.example.cafeteria.ui.components.AppHeader
import com.example.cafeteria.ui.components.AppProductSelector
import com.example.cafeteria.ui.components.AppTextField
import com.example.cafeteria.ui.theme.CafeteriaTheme

/**
 * Pantalla principal de la aplicación.
 *
 * @param modifier Modificador opcional paraa diseñar el contenedor raíz.
 */
@Composable
fun AppScreen(
    modifier: Modifier = Modifier,
    viewModel: AppViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        AppHeader()

        Spacer(modifier = Modifier.height(24.dp))

        AppTextField(username = uiState.username) { viewModel.updateUsername(it) }

        Spacer(modifier = Modifier.height(24.dp))

        AppProductSelector(option = uiState.option, onOptionSelected = { viewModel.updateOption(it) })

        Spacer(modifier = Modifier.height(24.dp))

        AppAmountSelector(amount = uiState.amount, onAmountChange = { viewModel.updateAmount(it) })

        Spacer(modifier = Modifier.height(24.dp))

        AppButton(text = "Añadir pedido (${uiState.amount * 10}€)") {
            viewModel.updateOrder()
        }

        Spacer(modifier = Modifier.height(24.dp))

        Divider()

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Lista de pedidos (${uiState.orderList.size}) para ${uiState.username}",
            color = Color.Green,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        uiState.orderList.forEach { order ->
            AppCard(
                image = order.drawable,
                product = order.product,
                price = order.price.toString(),
                amount = order.amount
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        Spacer(modifier = Modifier.height(24.dp))

        AppButton(text = stringResource(R.string.btn_confirm)) {
            viewModel.updateDialog()
        }
    }

    if (uiState.showDialog){
        AppConfirmDialog(
            onDismiss = { viewModel.dismissConfirmDialog() },
            onConfirm = { viewModel.confirmConfirmDialog() }
        )
    }

    if (uiState.showErrorDialog){
        val text = when(uiState.errorText) {
            1 -> stringResource(R.string.text_err_user_prod)
            2 -> stringResource(R.string.text_err_user)
            3 -> stringResource(R.string.text_err_prod)
            else -> stringResource(R.string.text_err_def)
        }
        AppErrorDialog(
            text = text,
            onDismiss = { viewModel.dismissErrorDialog() }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppScreenPreview(){
    CafeteriaTheme {
        AppScreen()
    }
}

