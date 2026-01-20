package com.example.cafeteria.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.cafeteria.ui.theme.CafeteriaTheme

/**
 * Componente que contiene un botón con un menú desplegaaable `DropDown`.
 * Permite al usuario elegir entre diferentes productos.
 *
 * @param option Producto actualmente seleccionado.
 * @param onOptionSelected Función que se ejecuta cuando el usuario elige una opción.
 */
@Composable
fun AppProductSelector(
    option: String,
    onOptionSelected: (String) -> Unit
) {
    val options = listOf("Jamón", "Tortilla", "Bacon")
    var expanded by remember { mutableStateOf(false) }

    Button(
        onClick = { expanded = true}
    ) {
        Row(verticalAlignment = Alignment.CenterVertically){
            Text(text = "Bocadillo: $option")
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { op ->
                DropdownMenuItem(
                    text = { Text(text = op) },
                    onClick = {
                        onOptionSelected(op)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun AppProductSelectorPreview() {
    CafeteriaTheme {
        AppProductSelector(
            option = "Jamón",
            onOptionSelected = {}
        )
    }
}