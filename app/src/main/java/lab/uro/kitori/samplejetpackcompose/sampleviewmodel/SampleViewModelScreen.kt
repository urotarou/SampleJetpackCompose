package lab.uro.kitori.samplejetpackcompose.sampleviewmodel

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lab.uro.kitori.samplecore.screen.AppScreen

@Preview
@Composable
fun PreviewSampleViewModelScreenLightNoName() {
    SampleViewModelScreen(
        false,
        name = ""
    )
}

@Preview
@Composable
fun PreviewSampleViewModelScreenLight() {
    SampleViewModelScreen(
        false,
        name = "light"
    )
}

@Preview
@Composable
fun PreviewSampleViewModelScreenDark() {
    SampleViewModelScreen(
        true,
        name = "dark"
    )
}

@Composable
fun SampleViewModelScreen(
    darkTheme: Boolean = isSystemInDarkTheme(),
    backIconOnClick: () -> Unit = {},
    shuffleButtonOnClick: () -> Unit = {},
    name: String = ""
) {
    AppScreen(
        darkTheme,
        "Sample ViewModel",
        backIconOnClick
    ) {
        val nameVisibility = name.isNotBlank()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp, 32.dp)
        ) {
            if (nameVisibility) {
                Text(
                    "name is $name",
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 24.sp
                )
            }

            Button(
                onClick = shuffleButtonOnClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {
                Text("Shuffle")
            }
        }
    }
}
