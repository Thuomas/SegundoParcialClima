package com.example.appdelclima.presentacion.clima

import com.example.appdelclima.repository.modelos.Clima

sealed class ClimaEstado{
    data class Exitoso(
        val ciudad: String = "",
        val temperatura: Double=0.0,
        val descripcion: String = "",
        val st: Double=0.0,
    ): ClimaEstado()
    data class Error(
        val mensaje: String = ""
    ): ClimaEstado()
    data object Vacio : ClimaEstado()
    data object Cargando : ClimaEstado()

}