package com.example.appdelclima.presentacion.ciudades

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appdelclima.presentacion.clima.ClimaView
import com.example.appdelclima.presentacion.clima.ClimaViewModel

@Composable
fun CiudadesPage() {
    val viewModel: ClimaViewModel = viewModel(factory = ClimaViewModel.factory)

    ClimaView(
        state = viewModel.uiState,
        onAction = { intencion ->
            viewModel.ejecutar(intencion)
        }
    )
}