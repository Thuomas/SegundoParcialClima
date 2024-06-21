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
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect

@Composable
fun ClimaView(
    modifier: Modifier = Modifier,
    state: ClimaEstado,
    onAction:(ClimaIntencion)->Unit
) {
    LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
        onAction(ClimaIntencion.actualizarClima)
    }
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
            is ClimaEstado.Vacio-> LoadingView()
            is ClimaEstado.Cargando-> EmptyView()
        }

        Spacer(modifier = Modifier.height(100.dp))

    }

}
@Composable
fun LoadingView(){
    Text(text = "Cargando")
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