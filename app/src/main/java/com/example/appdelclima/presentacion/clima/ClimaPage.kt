import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appdelclima.presentacion.clima.ClimaView
//MainPageUIState
import com.example.appdelclima.presentacion.clima.ClimaViewModel


@Composable
fun MainPage() {
    val viewModel: ClimaViewModel = viewModel(factory = ClimaViewModel.factory)

    ClimaView(
        state = viewModel.uiState,
        onAction = { intencion ->
            viewModel.ejecutar(intencion)
        }
    )
}

