package lab.uro.kitori.samplecore.screen

import android.widget.Toast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material.icons.filled.ImageSearch
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import lab.uro.kitori.samplecore.value.AppTheme

@Preview
@Composable
fun PreviewRootScreen() {
    RootScreen(
        title = "root"
    )
}

@Composable
fun RootScreen(
    darkTheme: Boolean = isSystemInDarkTheme(),
    title: String = "",
    content: @Composable () -> Unit = {}
) {
    AppTheme(darkTheme) {
        val context = LocalContext.current

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(title) },
                    actions = {
                        IconButton(onClick = {
                            Toast.makeText(context, "click image search", Toast.LENGTH_SHORT).show()
                        }) {
                            Icon(
                                imageVector = Icons.Default.ImageSearch,
                                contentDescription = "search"
                            )
                        }
                        IconButton(onClick = {
                            Toast.makeText(context, "click broken image", Toast.LENGTH_SHORT).show()
                        }) {
                            Icon(
                                imageVector = Icons.Default.BrokenImage,
                                contentDescription = "broken"
                            )
                        }
                    }
                )
            },
            content = { content() }
        )
    }
}
