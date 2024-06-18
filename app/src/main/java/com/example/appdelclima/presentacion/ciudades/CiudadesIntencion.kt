package com.example.appdelclima.presentacion.ciudades


sealed class CiudadesIntencion {
    object Buscar(val: String)  : CiudadesIntencion()
    object MostrarCaba : ClimaIntencion()
    object BorrarTodo : ClimaIntencion()
    object MostarError : ClimaIntencion()
}