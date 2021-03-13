package lab.uro.kitori.samplejetpackcompose.compose.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import lab.uro.kitori.samplejetpackcompose.compose.theme.AppTheme

@Preview
@Composable
fun PreviewBranchScreen() {
    BranchScreen(
        title = "branch"
    )
}

@Composable
fun BranchScreen(
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
            content = { content() }
        )
    }
}
