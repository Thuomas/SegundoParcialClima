package com.example.appdelclima.presentacion.clima

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appdelclima.ui.theme.AppDelClimaTheme

@Composable
fun ClimaView(
    modifier: Modifier = Modifier,
    state: ClimaEstado,
    onAction:(ClimaIntencion)->Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (state){
            is ClimaEstado.Error-> ErrorView(mensaje = state.mensaje)
            is ClimaEstado.Exitoso-> ClimaView(
                ciudad = state.ciudad,
                temperatura = state.temperatura,
                descripcion =state.descripcion,
                st = state.st)
            is ClimaEstado.Vacio-> EmptyView()
            is ClimaEstado.Cargando-> EmptyView()
        }

        Spacer(modifier = Modifier.height(100.dp))
        Button(onClick = { onAction(ClimaIntencion.BorrarTodo) }) {
            Text(text = "Borrar todo")
        }
        Button(onClick = { onAction(ClimaIntencion.MostrarCaba) }) {
            Text(text = "Mostrar Caba")
        }
        Button(onClick = { onAction(ClimaIntencion.MostrarCordoba) }) {
            Text(text = "Mostrar Cordoba")
        }
        Button(onClick = { onAction(ClimaIntencion.MostarError) }) {
            Text(text = "Mostrar Error")
        }
    }

}
@Composable
fun ErrorView(mensaje:String){
    Text(text = mensaje)
}

@Composable
fun EmptyView(){
    Text(text = "No hay datos que mostrar")
}

@Composable
fun ClimaView(ciudad: String, temperatura: Double, descripcion: String, st: Double){
    Column{
        Text(text = ciudad, style = MaterialTheme.typography.titleMedium)
        Text(
            text = "${temperatura}",
            style = MaterialTheme.typography.titleLarge
        )
        Text(text = descripcion, style = MaterialTheme.typography.bodyMedium)
        Text(
            text = "Sensacion termica ${st}°",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ClimaPreview() {
    AppDelClimaTheme {
        ClimaView(state = ClimaEstado.Vacio, onAction = {})
    }
}