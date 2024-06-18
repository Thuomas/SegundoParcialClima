package com.example.appdelclima.presentacion.ciudades

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.appdelclima.presentacion.clima.ClimaEstado
import com.example.appdelclima.presentacion.clima.ClimaIntencion


@Composable
fun CiudadesView(
    modifier: Modifier = Modifier,
    state: ClimaEstado,
    onAction:(ClimaIntencion)->Unit
) {
    Column(modifier = modifier){
        //todo
    }
}