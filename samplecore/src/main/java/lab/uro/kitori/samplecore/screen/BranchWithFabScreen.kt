package lab.uro.kitori.samplecore.screen

import android.widget.Toast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import lab.uro.kitori.samplecore.value.AppTheme

@Preview
@Composable
fun PreviewBranchWithFabScreen() {
    BranchWithFabScreen(
        title = "branch with fab"
    )
}

@Composable
fun BranchWithFabScreen(
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
            floatingActionButton = {
                val context = LocalContext.current
                FloatingActionButton(onClick = {
                    Toast.makeText(context, "click fab", Toast.LENGTH_SHORT).show()
                }) {
                    Icon(Icons.Default.Add, contentDescription = "fab")
                }
            },
            content = { content() }
        )
    }
}
