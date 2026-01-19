package com.example.cafeteria.ui.components

import android.app.AlertDialog
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cafeteria.ui.theme.CafeteriaTheme

@Composable
fun AppConfirmDialog(
    onDismiss: () -> Unit,
    onConfirm:() -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(onClick = onConfirm){ Text("Aceptar") }
        },
        title = { Text("Confirmación del pedido")},
        text = { Text("Gracias por realizar un pedido en la Cafetería Politécnico") },
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