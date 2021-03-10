package lab.uro.kitori.samplejetpackcompose.main

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lab.uro.kitori.samplejetpackcompose.compose.ui.RootScreenLayout

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
    RootScreenLayout(darkTheme, "Main") {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
        ) {
            Button(
                onClick = sampleViewModelButtonOnClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sample ViewModel")
            }
            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = sampleImageButtonOnClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sample Image")
            }
        }
    }
}
