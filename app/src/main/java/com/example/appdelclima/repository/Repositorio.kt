package com.example.appdelclima.repository

import com.example.appdelclima.repository.modelos.Ciudad
import com.example.appdelclima.repository.modelos.Clima

interface Repositorio {
    suspend fun buscarCiudad(ciudad: String): Array<Ciudad>
    suspend fun traerClima(ciudad: Ciudad): Clima
    suspend fun traerPronostico(ciudad: Ciudad): List<Clima>
}