package com.example.appdelclima.repository.modelos

data class Ciudad (
    val name : String,
    val lat : Float,
    val lon : Float,
    val country : String,
    val state: String? = null

)