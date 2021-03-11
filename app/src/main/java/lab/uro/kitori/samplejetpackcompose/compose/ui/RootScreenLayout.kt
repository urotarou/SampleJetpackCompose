package lab.uro.kitori.samplejetpackcompose.compose.ui

import android.widget.Toast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddComment
import androidx.compose.material.icons.filled.AddLink
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.ImageSearch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
            bottomBar = {
                BottomAppBar {
                    val selectedIndex = rememberSaveable { mutableStateOf(0) }

                    BottomNavigationItem(
                        selected = selectedIndex.value == 0,
                        onClick = {
                            selectedIndex.value = 0
                            Toast.makeText(context, "click call", Toast.LENGTH_SHORT).show()
                        },
                        icon = {
                            Icon(imageVector = Icons.Default.Call, contentDescription = "func")
                        },
                        label = { Text("call") }
                    )
                    BottomNavigationItem(
                        selected = selectedIndex.value == 1,
                        onClick = {
                            selectedIndex.value = 1
                            Toast.makeText(context, "click link", Toast.LENGTH_SHORT).show()
                        },
                        icon = {
                            Icon(imageVector = Icons.Default.AddLink, contentDescription = "func")
                        },
                        label = { Text("link") }
                    )
                    BottomNavigationItem(
                        selected = selectedIndex.value == 2,
                        onClick = {
                            selectedIndex.value = 2
                            Toast.makeText(context, "click comment", Toast.LENGTH_SHORT).show()
                        },
                        icon = {
                            Icon(
                                imageVector = Icons.Default.AddComment,
                                contentDescription = "func"
                            )
                        },
                        label = { Text("comment") }
                    )
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
