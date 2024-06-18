package com.example.appdelclima.repository

import com.example.appdelclima.repository.modelos.Ciudad
import com.example.appdelclima.repository.modelos.Clima
import com.example.appdelclima.repository.modelos.Clima2

class RepositorioMock : Repositorio {
    override suspend fun buscarCiudad(ciudad: String): List<Ciudad> {
        val ciudad1 = Ciudad(
            "Buenos Aires",
            lat = -23.0,
            lon = -24.3,
            //country = "Arg",
            state = "Argentina",
        )
        val ciudad2 = Ciudad(
            "Mar del Plata",
            lat = -22.0,
            lon = -25.3,
            //country = "Arg",
            state = "Argentina",
        )
        val ciudad3 = Ciudad(
            "Campana",
            lat = -33.0,
            lon = -44.3,
            //country = "Arg",
            state = "Argentina",
        )
        return listOf(ciudad1,ciudad2,ciudad3)
    }

    override suspend fun traerClima(ciudad: Ciudad): Clima2 {
        TODO("Not yet implemented")
    }

    override suspend fun traerPronostico(ciudad: Ciudad): List<Clima2> {
        TODO("Not yet implemented")
    }
}