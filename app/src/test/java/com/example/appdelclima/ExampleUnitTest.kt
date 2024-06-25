package com.example.appdelclima

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appdelclima.presentacion.ciudades.CiudadesEstado
import com.example.appdelclima.presentacion.ciudades.CiudadesIntencion
import com.example.appdelclima.presentacion.ciudades.CiudadesViewModel
import com.example.appdelclima.presentacion.ciudades.CiudadesViewModelFactory
import com.example.appdelclima.repository.RepositorioMock
import com.example.appdelclima.router.MockRouter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private val mianThreadSurrogate = newSingleThreadContext("UI thread")

    val repositorio = RepositorioMock()
    val router = MockRouter()
    val repositorioError = RepositorioMock()

    //armo el ViewModel
    val factory = CiudadesViewModelFactory(repositorio, router)
    val viewModel = factory.create(CiudadesViewModel::class.java)

    @Before
    fun setUp() {
        Dispatchers.setMain(mianThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mianThreadSurrogate.close()
    }

    @Test
    fun ciudadesViewModel_buscar_cor() = runTest(timeout = 3.seconds) {
        val estadoEsperado = CiudadesEstado.Resultado(listOf(repositorio.cordoba))

        launch(Dispatchers.Main) {
            viewModel.ejecutar(intencion = CiudadesIntencion.Buscar("cor"))
            delay(1.seconds)
            assertEquals(estadoEsperado, viewModel.uiState)

        }
    }

    @Test
    fun ciudadesViewModel_buscar_plata() = runTest(timeout = 3.seconds) {
        //Creo Valor esperado
        val estadoEsperado = CiudadesEstado.Resultado(listOf(repositorio.laPlata))

        launch(Dispatchers.Main) {
            viewModel.ejecutar(intencion = CiudadesIntencion.Buscar("plata"))
            delay(1.milliseconds)
            assertEquals(estadoEsperado, viewModel.uiState)
        }
    }

    @Test
    fun ciudadesViewModel_buscar_vacio() = runTest(timeout = 3.seconds) {
        //Creo Valor esperado
        val estadoEsperado = CiudadesEstado.Vacio

        launch(Dispatchers.Main) {
            viewModel.ejecutar(intencion = CiudadesIntencion.Buscar("jojo"))
            delay(1.milliseconds)
            assertEquals(estadoEsperado, viewModel.uiState)
        }
    }

    @Test
    fun ciudadesViewModel_buscar_error() = runTest(timeout = 3.seconds) {

        val factory = CiudadesViewModelFactory(repositorioError, router)
        val viewModel = factory.create(CiudadesViewModel::class.java)

        val estadoEsperado = CiudadesEstado.Error("error")

        launch(Dispatchers.Main) {
            viewModel.ejecutar(intencion = CiudadesIntencion.Buscar(""))
            delay(1.milliseconds)
            assertEquals(estadoEsperado, viewModel.uiState)
        }
    }

    @Test
    fun ciudadesViewModel_buscar_case_insensitive() = runTest(timeout = 3.seconds) {

        val estadoEsperado = CiudadesEstado.Resultado(listOf(repositorio.cordoba))
           launch(Dispatchers.Main) {
               viewModel.ejecutar(intencion = CiudadesIntencion.Buscar("COrDObA"))
               delay(1.milliseconds)
               assertEquals(estadoEsperado, viewModel.uiState)
           }

    }


}