package lab.uro.kitori.samplecore.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import lab.uro.kitori.samplecore.value.AppTheme
import lab.uro.kitori.samplecore.value.NavigationScreen
import lab.uro.kitori.samplecore.value.barBackgroundColor

@Composable
fun AppScreen(
    darkTheme: Boolean = isSystemInDarkTheme(),
    title: String? = null,
    topBackAction: (() -> Unit)? = null,
    topOptionActions: (MutableList<Pair<ImageVector, () -> Unit>>.() -> Unit)? = null,
    topAppBarExtensionArea: @Composable (() -> Unit)? = null,
    bottomNavigationItems: (MutableList<NavigationScreen>.() -> Unit)? = null,
    content: @Composable () -> Unit = {}
) {
    AppTheme(darkTheme) {
        val navController: NavHostController = rememberNavController()

        val hasTopAppBar = title != null
        val actions = mutableListOf<Pair<ImageVector, () -> Unit>>()
        topOptionActions?.invoke(actions)

        val screens = mutableListOf<NavigationScreen>()
        bottomNavigationItems?.invoke(screens)
        val hasBottomNav = screens.isNotEmpty()

        Scaffold(
            topBar = {
                Column {
                    if (hasTopAppBar) {
                        ComposeTopBar(
                            title.orEmpty(),
                            topBackAction,
                            actions.takeIf { it.isNotEmpty() }
                        )
                    }
                    if (topAppBarExtensionArea != null) {
                        Box(
                            modifier = Modifier.background(MaterialTheme.colors.background)
                        ) {
                            topAppBarExtensionArea()
                        }
                    }
                }
            },
            bottomBar = {
                if (hasBottomNav) {
                    ComposeBottomBar(navController, screens)
                }
            }
        ) {
            if (hasBottomNav) {
                // composeのpreviewを見たいときはこれをコメントアウトすること
                ComposeBottomBarNavHost(navController, screens, it)
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(it)
            ) {
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    content()
                }
            }
        }
    }
}

@Composable
private fun ComposeTopBar(
    title: String,
    topBackAction: (() -> Unit)?,
    topOptionActions: List<Pair<ImageVector, () -> Unit>>?
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = topBackAction?.let {
            {
                IconButton(onClick = {
                    it()
                }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
                }
            }
        },
        actions = {
            topOptionActions?.forEach { (icon, onClick) ->
                IconButton(onClick = onClick) {
                    Icon(imageVector = icon, contentDescription = null)
                }
            }
        },
        backgroundColor = barBackgroundColor()
    )
}

@Composable
private fun ComposeBottomBar(
    navController: NavHostController,
    screens: List<NavigationScreen>
) {
    BottomNavigation(
        backgroundColor = barBackgroundColor()
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        screens.forEach { screen ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.key } == true,
                onClick = {
                    navController.navigate(screen.key) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = screen.description
                    )
                },
                label = {
                    Text(text = stringResource(screen.labelResId))
                }
            )
        }
    }
}

@Composable
private fun ComposeBottomBarNavHost(
    navController: NavHostController,
    screens: List<NavigationScreen>,
    paddingValues: PaddingValues
) {
    val firstScreen = screens.firstOrNull() ?: return

    NavHost(
        navController = navController,
        startDestination = firstScreen.key,
        modifier = Modifier.padding(paddingValues)
    ) {
        screens.forEach { screen ->
            composable(screen.key) { screen.composableScreen() }
        }
    }
}
