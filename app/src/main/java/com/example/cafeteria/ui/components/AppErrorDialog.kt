package com.example.cafeteria.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cafeteria.R
import com.example.cafeteria.ui.theme.CafeteriaTheme

/**
 * Componente de diálogo que muestra un error al realizar el pedido.
 * Este diálogo salta al no contener el nombre del usuario, cuando no se
 * ha añadido un producto al pedido o ambos.
 *
 * @param text Mensaje de error personalizado que se muestra al usuario.
 * @param onDismiss Función que se ejecuta cuando se cierra el diálogo dándole, o no, al botón "Entendido".
 */
@Composable
fun AppErrorDialog(
    text: String,
    onDismiss: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(onClick = onDismiss){
                Text(text = stringResource(R.string.btn_err))
            }
        },
        title = { Text(text = stringResource(R.string.title_err_dialog)) },
        text = { Text(text = text) },
        icon = {
            Icon(
                imageVector = Icons.Outlined.Close,
                contentDescription = null,
                modifier = Modifier.size(48.dp),
                tint = Color.Red
            )
        },

        )
}

@Preview
@Composable
fun AppErrorDialogPreview(){
    CafeteriaTheme {
        AppErrorDialog(
            text = stringResource(R.string.text_err_user),
            onDismiss = {}
        )
    }
}