import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appdelclima.presentacion.clima.actual.ClimaView
//MainPageUIState
import com.example.appdelclima.presentacion.clima.actual.ClimaViewModel
import androidx.navigation.NavHostController
import com.example.appdelclima.presentacion.clima.actual.ClimaViewModelFactory
import com.example.appdelclima.presentacion.clima.pronostico.PronosticoView
import com.example.appdelclima.presentacion.clima.pronostico.PronosticoViewModel
import com.example.appdelclima.presentacion.clima.pronostico.PronosticoViewModelFactory
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
    val pronosticoViewModel : PronosticoViewModel = viewModel(
        factory = PronosticoViewModelFactory(
            repositorio = RepositorioApi(),
            router= Enrutador(navHostController),
            nombre = nombre
        )
    )
    Column(modifier = Modifier.padding(16.dp)){
        ClimaView(
            state = viewModel.uiState,
            onAction = { intencion ->
                viewModel.ejecutar(intencion)
            }
        )
        PronosticoView(
            state = pronosticoViewModel.uiState,
            onAction = { intencion ->
                pronosticoViewModel.ejecutar(intencion)
            }
        )
    }


}

