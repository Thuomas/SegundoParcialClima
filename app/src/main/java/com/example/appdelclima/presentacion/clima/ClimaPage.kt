import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appdelclima.presentacion.clima.actual.ClimaView
//MainPageUIState
import com.example.appdelclima.presentacion.clima.actual.ClimaViewModel
import androidx.navigation.NavHostController
import com.example.appdelclima.presentacion.clima.actual.ClimaViewModelFactory
import com.example.appdelclima.repository.RepositorioApi
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

