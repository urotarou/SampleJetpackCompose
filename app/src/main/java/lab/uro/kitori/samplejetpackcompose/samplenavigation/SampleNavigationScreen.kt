package lab.uro.kitori.samplejetpackcompose.samplenavigation

import android.widget.Toast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import lab.uro.kitori.samplecore.screen.AppScreen
import lab.uro.kitori.samplecore.value.NavigationScreen
import lab.uro.kitori.samplejetpackcompose.R
import lab.uro.kitori.samplejetpackcompose.samplenavigation.screen.CommentLayout
import lab.uro.kitori.samplejetpackcompose.samplenavigation.screen.HomeLayout
import lab.uro.kitori.samplejetpackcompose.samplenavigation.screen.LinkLayout
import lab.uro.kitori.samplejetpackcompose.samplenavigation.screen.PhotoLayout

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
    val context = LocalContext.current

    AppScreen(
        darkTheme = darkTheme,
        title = "Sample Navigation",
        topBackAction = backIconOnClick,
        topOptionActions = {
            add(Icons.Default.Search to {
                Toast.makeText(context, "search", Toast.LENGTH_SHORT).show()
            })
        },
        bottomNavigationItems = {
            add(NavigationScreen("home", Icons.Default.Home, R.string.home) {
                HomeLayout()
            })
            add(NavigationScreen("photo", Icons.Default.Photo, R.string.photo) {
                PhotoLayout()
            })
            add(NavigationScreen("comment", Icons.Default.Comment, R.string.comment) {
                CommentLayout()
            })
            add(NavigationScreen("link", Icons.Default.Link, R.string.link) {
                LinkLayout()
            })
        }
    )
}
