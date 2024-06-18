package com.example.appdelclima.repository

import com.example.appdelclima.repository.modelos.Ciudad
import com.example.appdelclima.repository.modelos.Clima
import com.example.appdelclima.repository.modelos.Clima2

interface Repositorio {
    suspend fun buscarCiudad(ciudad: String): List<Ciudad>
    suspend fun traerClima(ciudad: Ciudad): Clima2
    suspend fun traerPronostico(ciudad: Ciudad): List<Clima2>
}