package lab.uro.kitori.samplejetpackcompose.compose.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CallEnd
import androidx.compose.material.icons.filled.CallMissed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    content: @Composable () -> Unit = {}
) {
    AppTheme(darkTheme) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(title) }
                )
            },
            bottomBar = {
                BottomAppBar {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Call, contentDescription = "func")
                    }
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.CallEnd, contentDescription = "func")
                    }
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.CallMissed, contentDescription = "func")
                    }
                }
            },
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = it.calculateBottomPadding())
                ) {
                    content()
                }
            }
        )
    }
}
