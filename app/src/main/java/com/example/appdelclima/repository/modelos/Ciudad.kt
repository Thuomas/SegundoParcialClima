package com.example.appdelclima.repository.modelos

data class Ciudad (
    val name : String,
    val lat : Double,
    val lon : Double,
    val country : String,
    val state: String? = null

)