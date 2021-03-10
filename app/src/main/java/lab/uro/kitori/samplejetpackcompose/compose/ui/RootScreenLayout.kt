package lab.uro.kitori.samplejetpackcompose.compose.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lab.uro.kitori.samplejetpackcompose.compose.theme.AppTheme

@Preview
@Composable
fun PreviewRootScreenLayout() {
    RootScreenLayout(
        title = "root"
    )
}

@Composable
fun RootScreenLayout(
    darkTheme: Boolean = isSystemInDarkTheme(),
    title: String = "",
    content: @Composable (PaddingValues) -> Unit = {}
) {
    AppTheme(darkTheme) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(title) },
                    elevation = 4.dp
                )
            },
            content = content
        )
    }
}
