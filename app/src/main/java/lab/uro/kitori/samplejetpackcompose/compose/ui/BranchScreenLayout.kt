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
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import lab.uro.kitori.samplejetpackcompose.compose.theme.AppTheme

@Preview
@Composable
fun PreviewBranchScreenLayout() {
    BranchScreenLayout(
        title = "branch"
    )
}

@Composable
fun BranchScreenLayout(
    darkTheme: Boolean = isSystemInDarkTheme(),
    title: String = "",
    backIconOnClick: () -> Unit = {},
    content: @Composable () -> Unit = {}
) {
    AppTheme(darkTheme) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(title) },
                    navigationIcon = {
                        IconButton(onClick = backIconOnClick) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
                        }
                    }
                )
            },
            bottomBar = {
                BottomAppBar {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Apps, contentDescription = "func")
                    }
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Apps, contentDescription = "func")
                    }
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Apps, contentDescription = "func")
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
