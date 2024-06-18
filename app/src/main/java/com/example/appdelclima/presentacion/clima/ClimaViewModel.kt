package com.example.appdelclima.presentacion.clima

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.appdelclima.repository.Repositorio
import com.example.appdelclima.repository.RepositorioApi
import com.example.appdelclima.repository.RepositorioMock
import com.example.appdelclima.repository.modelos.Ciudad
import com.example.appdelclima.repository.modelos.Clima
import kotlinx.coroutines.launch

class ClimaViewModel(
    val repositorio : Repositorio
) : ViewModel() {

    companion object{
        val factory : ViewModelProvider.Factory = viewModelFactory{
            initializer {
                val repositorio = RepositorioApi()
                ClimaViewModel(repositorio)
            }
        }
    }
    var uiState by mutableStateOf<ClimaEstado>(ClimaEstado.Vacio)

    private val climaCordoba = Clima(
        ciudad = "Cordoba",
        temperatura = 14,
        estado = "nubado",
        humedad = 18.0F,
        st = 10,
        viento = 30,
        latitud = 1234,
        longitud = 4321,
    )

    private val climaCaba = Clima(
        ciudad = "Caba",
        temperatura = 20,
        estado = "Soleado",
        humedad = 83.0F,
        st = 30,
        viento = 30,
        latitud = 1234321,
        longitud = 4321123,
    )

    fun ejecutar(intencion: ClimaIntencion) {
        when (intencion) {
            ClimaIntencion.MostrarCordoba -> mostrarCordoba()
            ClimaIntencion.MostrarCaba -> mostrarCaba()
            ClimaIntencion.BorrarTodo -> borrarTodo()
            ClimaIntencion.MostarError -> mostrarError()
        }
    }
    private fun mostrarError() {
        uiState = ClimaEstado.Error("Este es un error de mentirassss")
    }
    private fun borrarTodo() {
        uiState = ClimaEstado.Vacio
    }

    private fun mostrarCaba() {
        /*uiState = ClimaEstado.Exitoso(
            ciudad = climaCaba.ciudad,
            temperatura = climaCaba.temperatura,
            descripcion = climaCaba.estado,
            st = climaCaba.st
        )*/
    }

    private fun mostrarCordoba() {
        ClimaEstado.Cargando
        viewModelScope.launch {
            val cordoba = Ciudad(name = "cordoba", lat = -31.4135, lon = -64.18105, state = "Ar")
            try {
                val clima = repositorio.traerClima(cordoba)
                ClimaEstado.Exitoso(
                    ciudad = clima.name,
                    temperatura = 10.0,//clima.main.temp,
                    descripcion = "asd",//clima.weather.first().description,
                    st = 10.0 //clima.main.feelsLike
                )
            } catch (e: Exception) {
                ClimaEstado.Error("este es mi mensaje de error")
            }

        }

    }
}