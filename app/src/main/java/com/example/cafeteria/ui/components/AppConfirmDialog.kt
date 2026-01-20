package com.example.cafeteria.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cafeteria.R
import com.example.cafeteria.ui.theme.CafeteriaTheme

/**
 * Componente de diálogo para realizar la confirmación del pedido.
 *
 * @param onDismiss Función que se ejecuta cuando se cierra el diálogo sin darle al botón "Aceptar".
 * @param onConfirm Función que se ejecuta al pulsar el botón "Aceptar".
 */
@Composable
fun AppConfirmDialog(
    onDismiss: () -> Unit,
    onConfirm:() -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(onClick = onConfirm){
                Text(text = stringResource(R.string.btn_accept))
            }
        },
        title = { Text(text = stringResource(R.string.title_dialog)) },
        text = { Text(text = stringResource(R.string.text_dialog)) },
        icon = {
            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = null,
                modifier = Modifier.size(48.dp),
                tint = MaterialTheme.colorScheme.primary
            )
        },

    )
}

@Preview
@Composable
fun AppConfirmDialogPreview(){
    CafeteriaTheme {
        AppConfirmDialog(
            onDismiss = {},
            onConfirm = {}
        )
    }
}