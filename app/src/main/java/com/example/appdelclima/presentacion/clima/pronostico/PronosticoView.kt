package com.example.appdelclima.presentacion.clima.pronostico

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import com.example.appdelclima.presentacion.clima.actual.EmptyView
import com.example.appdelclima.presentacion.clima.actual.ErrorView
import com.example.appdelclima.presentacion.clima.actual.LoadingView
import com.example.appdelclima.repository.modelos.ListForecast

@Composable
fun PronosticoView (
    modifier: Modifier = Modifier,
    state: PronosticoEstado,
    onAction: (PronosticoIntencion)->Unit
    ){
    LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
        onAction(PronosticoIntencion.actualizarClima)
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when(state){
            is PronosticoEstado.Error -> ErrorView(mensaje = state.mensaje)
            is PronosticoEstado.Exitoso -> PronosticoView(state.climas)
            PronosticoEstado.Vacio -> LoadingView()
            PronosticoEstado.Cargando -> EmptyView()
        }
        Spacer(modifier = Modifier.height(100.dp))
    }
}
@Composable
fun EmptyView(){
    Text(text = "No hay nada que mostrar")
}

@Composable
fun LoadingView(){
    Text(text = "Cargando")
}

@Composable
fun ErrorView(mensaje: String){
    Text(text = mensaje)
}

@Composable
fun PronosticoView(climas: List<ListForecast>){
    Text(text = "Pronostico para los siguientes dias")
    LazyColumn {
        items(items = climas) {
            Card() {
                Text(text = "Temperatura: ${it.main.temp}")
                Text(text = "Temperatura minima: ${it.main.temp_min}")
                Text(text = "Temperatura maxima: ${it.main.temp_max}")
                Text(text = "Humedad: ${it.main.humidity}%")
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}