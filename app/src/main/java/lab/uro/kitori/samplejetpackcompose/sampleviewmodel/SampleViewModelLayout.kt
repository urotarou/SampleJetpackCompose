package lab.uro.kitori.samplejetpackcompose.sampleviewmodel

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import lab.uro.kitori.samplejetpackcompose.compose.ui.BranchScreenLayout

@Preview
@Composable
fun PreviewLayoutLight() {
    ScreenLayout(false)
}

@Preview
@Composable
fun PreviewLayoutDark() {
    ScreenLayout(true)
}

@Composable
fun ScreenLayout(
    darkTheme: Boolean = isSystemInDarkTheme(),
    viewModel: SampleViewModelViewModel = viewModel(),
    backIconOnClick: () -> Unit = {},
    shuffleButtonOnClick: () -> Unit = {}
) {
    val name by viewModel.name.observeAsState("")

    BranchScreenLayout(
        darkTheme,
        "Sample ViewModel",
        backIconOnClick
    ) {
        val nameVisibility = name.isNotBlank()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp, 32.dp),
            verticalArrangement = if (nameVisibility) {
                Arrangement.SpaceBetween
            } else {
                Arrangement.Bottom
            }
        ) {
            if (nameVisibility) {
                Text("name is $name")
            }

            Button(
                onClick = shuffleButtonOnClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Shuffle")
            }
        }
    }
}
