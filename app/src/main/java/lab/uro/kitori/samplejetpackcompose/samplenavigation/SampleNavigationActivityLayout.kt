package lab.uro.kitori.samplejetpackcompose.samplenavigation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import lab.uro.kitori.samplejetpackcompose.compose.ui.NavigationScreenLayout
import lab.uro.kitori.samplejetpackcompose.samplenavigation.screen.CommentLayout
import lab.uro.kitori.samplejetpackcompose.samplenavigation.screen.HomeLayout
import lab.uro.kitori.samplejetpackcompose.samplenavigation.screen.LinkLayout
import lab.uro.kitori.samplejetpackcompose.samplenavigation.screen.PhotoLayout
import lab.uro.kitori.samplejetpackcompose.samplenavigation.screen.Screen

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
    val navController = rememberNavController()
    NavigationScreenLayout(
        darkTheme,
        "Sample Navigation",
        navController,
        backIconOnClick
    ) {
        NavHost(navController = navController, startDestination = Screen.HOME.route) {
            composable(Screen.HOME.route) { HomeLayout(navController) }
            composable(Screen.PHOTO.route) { PhotoLayout(navController) }
            composable(Screen.COMMENT.route) { CommentLayout(navController) }
            composable(Screen.LINK.route) { LinkLayout(navController) }
        }
    }
}
