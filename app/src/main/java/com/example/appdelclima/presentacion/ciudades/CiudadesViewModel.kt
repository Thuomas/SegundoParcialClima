package com.example.appdelclima.presentacion.ciudades

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appdelclima.repository.Repositorio

class CiudadesViewModel(
    val repositorio: Repositorio
) : ViewModel() {
}

class CiudadesViewModelFactory(
    private val repositorio: Repositorio
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CiudadesViewModel::class.java)) {
        return CiudadesViewModel(repositorio) as T
    }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}