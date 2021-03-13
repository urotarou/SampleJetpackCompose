package lab.uro.kitori.samplejetpackcompose.compose.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import lab.uro.kitori.samplejetpackcompose.compose.theme.AppTheme
import lab.uro.kitori.samplejetpackcompose.samplenavigation.screen.Screen

@Preview
@Composable
fun PreviewNavigationScreenLayout() {
    NavigationScreenLayout(
        title = "navigation",
        screen = Screen.values().toList()
    )
}

@Composable
fun NavigationScreenLayout(
    darkTheme: Boolean = isSystemInDarkTheme(),
    title: String = "",
    navController: NavHostController = rememberNavController(),
    backIconOnClick: () -> Unit = {},
    screen: List<Screen> = listOf(),
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
                BottomNavigation {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)

                    screen.forEach {
                        BottomNavigationItem(
                            selected = currentRoute == it.route,
                            onClick = {
                                navController.navigate(it.route) {
                                    popUpTo = navController.graph.startDestination
                                    launchSingleTop = true
                                }
                            },
                            icon = {
                                Icon(imageVector = it.icon, contentDescription = "func")
                            },
                            label = { Text(it.label) }
                        )
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
