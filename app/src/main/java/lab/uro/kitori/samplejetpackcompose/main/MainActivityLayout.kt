package lab.uro.kitori.samplejetpackcompose.main

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lab.uro.kitori.samplejetpackcompose.compose.theme.AppTheme

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
    sampleViewModelButtonOnClick: () -> Unit = {},
    sampleImageButtonOnClick: () -> Unit = {}
) {
    AppTheme(darkTheme) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Main") },
                    elevation = 4.dp
                )
            }
        ) {
            Column(
                modifier = Modifier.padding(16.dp, 32.dp)
            ) {
                Button(
                    onClick = sampleViewModelButtonOnClick
                ) {
                    Text("Sample ViewModel")
                }
                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = sampleImageButtonOnClick
                ) {
                    Text("Sample Image")
                }
            }
        }
    }
}
