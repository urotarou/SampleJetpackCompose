package lab.uro.kitori.samplejetpackcompose.samplefab

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import lab.uro.kitori.samplejetpackcompose.compose.ui.BranchWithFabScreen

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
    backIconOnClick: () -> Unit = {}
) {
    BranchWithFabScreen(
        darkTheme,
        "Sample FAB",
        backIconOnClick
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                "FAB",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
