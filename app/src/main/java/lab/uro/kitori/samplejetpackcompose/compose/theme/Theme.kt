package lab.uro.kitori.samplejetpackcompose.compose.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkThemeColors = darkColors(
    primary = ColorDarkPrimary,
    primaryVariant = ColorDarkPrimaryVariant,
    secondary = ColorDarkSecondary,
    secondaryVariant = ColorDarkSecondaryVariant,
    background = ColorDarkBackground,
    surface = ColorDarkSurface,
    error = ColorDarkError,
    onPrimary = ColorDarkOnPrimary,
    onSecondary = ColorDarkOnSecondary,
    onBackground = ColorDarkOnBackground,
    onSurface = ColorDarkOnSurface,
    onError = ColorDarkOnError
)

private val LightThemeColors = lightColors(
    primary = ColorPrimary,
    primaryVariant = ColorPrimaryVariant,
    secondary = ColorSecondary,
    secondaryVariant = ColorSecondaryVariant,
    background = ColorBackground,
    surface = ColorSurface,
    error = ColorError,
    onPrimary = ColorOnPrimary,
    onSecondary = ColorOnSecondary,
    onBackground = ColorOnBackground,
    onSurface = ColorOnSurface,
    onError = ColorOnError
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) {
            DarkThemeColors
        } else {
            LightThemeColors
        },
        content = content
    )
}
