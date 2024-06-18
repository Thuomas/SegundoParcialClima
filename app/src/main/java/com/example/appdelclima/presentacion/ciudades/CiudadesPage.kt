package com.example.appdelclima.presentacion.ciudades

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.appdelclima.presentacion.clima.ClimaView
import com.example.appdelclima.presentacion.clima.ClimaViewModel
import com.example.appdelclima.repository.RepositorioApi
import com.example.appdelclima.repository.RepositorioMock
import com.example.appdelclima.router.Enrutador
import com.example.appdelclima.router.Router

@Composable
fun CiudadesPage(
    navHostController: NavHostController
) {

    val viewModel: CiudadesViewModel = viewModel(
        factory = CiudadesViewModelFactory(
            repositorio = RepositorioApi(),
            router= Enrutador(navHostController)
        )
    )
    CiudadesView(
        state = viewModel.uiState,
        onAction = { intencion ->
            viewModel.ejecutar(intencion)
        }
    )
}