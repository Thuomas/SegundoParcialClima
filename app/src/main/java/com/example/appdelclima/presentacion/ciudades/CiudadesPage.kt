package com.example.appdelclima.presentacion.ciudades

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appdelclima.presentacion.clima.ClimaView
import com.example.appdelclima.presentacion.clima.ClimaViewModel
import com.example.appdelclima.repository.RepositorioApi
import com.example.appdelclima.repository.RepositorioMock

@Composable
fun CiudadesPage() {

    val viewModel: CiudadesViewModel = viewModel(
        factory = CiudadesViewModelFactory(
            repositorio = RepositorioMock()
        )
    )
    CiudadesView(
        state = viewModel.uiState,
        onAction = { intencion ->
            viewModel.ejecutar(intencion)
        }
    )
}