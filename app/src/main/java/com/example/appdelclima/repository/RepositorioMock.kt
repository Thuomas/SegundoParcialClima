package com.example.appdelclima.repository

import com.example.appdelclima.repository.modelos.Ciudad
import com.example.appdelclima.repository.modelos.Clima

class RepositorioMock : Repositorio {

        val ciudad1 = Ciudad(
            "Buenos Aires",
            lat = -23.0f,
            lon = -24.3f,
            //country = "Arg",
            country = "Argentina",
        )
        val ciudad2 = Ciudad(
            "Mar del Plata",
            lat = -22.0f,
            lon = -25.3f,
            //country = "Arg",
            country = "Argentina",
        )
        val ciudad3 = Ciudad(
            "Campana",
            lat = -33.0f,
            lon = -44.3f,
            //country = "Arg",
            country = "Argentina",
        )
        val ciudades = listOf(ciudad1,ciudad2,ciudad3)
    override suspend fun buscarCiudad(ciudad:String): List<Ciudad> {
        if (ciudad == "error") {
            throw Exception("Error")
        }
        return ciudades.filter { it.name.contains(ciudad, ignoreCase = true) }
    }


    override suspend fun traerClima(lat: Float, lon: Float): Clima {
        TODO("Not yet implemented")

    }

    override suspend fun traerPronostico(ciudad: Ciudad): List<Clima> {
        TODO("Not yet implemented")
    }
}