package com.example.appdelclima.repository

import com.example.appdelclima.repository.modelos.Ciudad
import com.example.appdelclima.repository.modelos.Clima

class RepositorioMock : Repositorio {
    override suspend fun buscarCiudad(ciudad: String): Array<Ciudad> {
        val ciudad1 = Ciudad(
            "Buenos Aires",
            lat = -23.0,
            lon = -24.3,
            //country = "Arg",
            country = "Argentina",
        )
        val ciudad2 = Ciudad(
            "Mar del Plata",
            lat = -22.0,
            lon = -25.3,
            //country = "Arg",
            country = "Argentina",
        )
        val ciudad3 = Ciudad(
            "Campana",
            lat = -33.0,
            lon = -44.3,
            //country = "Arg",
            country = "Argentina",
        )
        return arrayOf(ciudad1,ciudad2,ciudad3)
    }

    override suspend fun traerClima(ciudad: Ciudad): Clima {
        TODO("Not yet implemented")
    }

    override suspend fun traerPronostico(ciudad: Ciudad): List<Clima> {
        TODO("Not yet implemented")
    }
}