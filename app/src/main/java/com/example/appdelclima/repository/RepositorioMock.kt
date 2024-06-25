package com.example.appdelclima.repository

import com.example.appdelclima.repository.modelos.Ciudad
import com.example.appdelclima.repository.modelos.Clima
import com.example.appdelclima.repository.modelos.ListForecast

class RepositorioMock : Repositorio {

        val cordoba = Ciudad(
            "Cordoba",
            lat = -23.0f,
            lon = -24.3f,
            country = "Argentina",
        )
        val bsAs = Ciudad(
            "Buenos Aires",
            lat = -22.0f,
            lon = -25.3f,
            country = "Argentina",
        )
        val laPlata = Ciudad(
            "La Plata",
            lat = -33.0f,
            lon = -44.3f,
            country = "Argentina",
        )
        val ciudades = listOf(cordoba,bsAs,laPlata)
    override suspend fun buscarCiudad(ciudad:String): List<Ciudad> {
        if (ciudad == "error") {
            throw Exception("Error")
        }
        return ciudades.filter { it.name.contains(ciudad, ignoreCase = true) }
    }


    override suspend fun traerClima(lat: Float, lon: Float): Clima {
        TODO("Not yet implemented")

    }

    override suspend fun traerPronostico(nombre: String): List<ListForecast> {
        TODO("Not yet implemented")
    }
}

class RepositorioMockError  : Repositorio {

    override suspend fun buscarCiudad(ciudad: String): List<Ciudad> {
        throw Exception()
    }

    override suspend fun traerClima(lat: Float, lon: Float): Clima {
        throw Exception()
    }

    override suspend fun traerPronostico(nombre: String): List<ListForecast> {
        throw Exception()
    }
}