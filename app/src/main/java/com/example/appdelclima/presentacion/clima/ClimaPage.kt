import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appdelclima.presentacion.clima.ClimaView
//MainPageUIState
import com.example.appdelclima.presentacion.clima.ClimaViewModel
import com.example.appdelclima.router.Router
import androidx.navigation.NavHostController
import com.example.appdelclima.presentacion.ciudades.CiudadesViewModel
import com.example.appdelclima.presentacion.ciudades.CiudadesViewModelFactory
import com.example.appdelclima.presentacion.clima.ClimaViewModelFactory
import com.example.appdelclima.repository.RepositorioApi
import com.example.appdelclima.repository.RepositorioMock
import com.example.appdelclima.router.Enrutador


@Composable
fun ClimaPage(
    navHostController: NavHostController,
    lat : Float,
    lon : Float,
    nombre: String
) {

    val viewModel: ClimaViewModel = viewModel(
        factory = ClimaViewModelFactory(
            repositorio = RepositorioApi(),
            router= Enrutador(navHostController),
            lat = lat,
            lon = lon,
           nombre = nombre
        )
    )

    ClimaView(
        state = viewModel.uiState,
        onAction = { intencion ->
            viewModel.ejecutar(intencion)
        }
    )
}

