package com.example.appdelclima.presentacion.ciudades

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.appdelclima.repository.modelos.Ciudad


@Composable
fun CiudadesView(
    modifier: Modifier = Modifier,
    state: CiudadesEstado,
    onAction: (CiudadesIntencion) -> Unit
) {
    var value by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bienvenido a su aplicacion del clima",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,

            )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = value,
            label = { Text(text = "Buscar por nombre") },
            onValueChange = {
                value = it
                onAction(CiudadesIntencion.Buscar(value))
            },
        )
        Spacer(modifier = Modifier.height(20.dp))
        when (state) {
            is CiudadesEstado.Cargando -> Text(text = "Cargando")
            is CiudadesEstado.Error -> Text(text = state.mensaje)
            is CiudadesEstado.Resultado -> ListaDeCiudades(state.ciudades)
            {
                onAction(
                    CiudadesIntencion.Seleccionar(it)
                )
            }

            CiudadesEstado.Vacio -> Text(text = "No hay resultados")
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaDeCiudades(ciudades: List<Ciudad>, onSelect: (Ciudad) -> Unit) {
    LazyColumn() {
        items(items = ciudades) {

            Card(
                modifier = Modifier
                    .width(240.dp)
                    .height(100.dp),
                shape = RoundedCornerShape(16.dp),
                onClick = { onSelect(it) }) {

                Text(
                    text = it.name,
                    textAlign = TextAlign.Center,
                )
            }
            /* ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .width(240.dp)
                    .height(100.dp)
                ,

                onClick = { onSelect(it) }
            ) {
                Text(
                    text = it.name,
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Center,)
            }*/
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}
