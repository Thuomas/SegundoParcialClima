package com.example.appdelclima.repository.modelos

import kotlinx.serialization.Serializable

/*data class Clima(
    val temperatura: Int,
    val humedad: Float,
    val ciudad: String,
    val st: Int,
    val viento: Int,
    val latitud: Long,
    val longitud: Long,
    val estado: String
)*/

@Serializable
data class Clima(
    val base: String,
    val name: String,
    val coord: Coord,
    val weather: List<Weather>,
    val main: Main,
    val wind: Wind,
    val clouds: Clouds,
    val sys: Sys
)

@Serializable
data class Coord(
    val lon: Double,
    val lat: Double,
)

@Serializable
data class Weather(
    val id: Long,
    val main: String,
    val description: String,
    val icon: String,
)

@Serializable
data class Main(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Long,
    val humidity: Long,
)

@Serializable
data class Wind(
    val speed: Double,
    val deg: Long,
    val gust: Double? = null,
)

@Serializable
data class Clouds(
    val all: Long,
)

@Serializable
data class Sys(
    val type: Long,
    val id: Long,
    val country: String,
    val sunrise: Long,
    val sunset: Long,
)