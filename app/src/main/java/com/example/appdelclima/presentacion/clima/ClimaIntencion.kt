package com.example.appdelclima.presentacion.clima

sealed class ClimaIntencion {
    object MostrarCordoba : ClimaIntencion()
    object MostrarCaba : ClimaIntencion()
    object BorrarTodo : ClimaIntencion()
    object MostarError : ClimaIntencion()
}