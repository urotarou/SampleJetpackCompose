package lab.uro.kitori.samplecore.value

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// light
val ColorPrimary = Color(0xff80ee02)
val ColorPrimaryVariant = Color(0xff45bb00)

val ColorSecondary = Color(0xff7002ee)
val ColorSecondaryVariant = Color(0xff2c00ba)

val ColorBackground = Color(0xffffffff)
val ColorSurface = Color(0xffffffff)
val ColorError = Color(0xffb00020)

val ColorOnPrimary = Color(0xff000000)
val ColorOnSecondary = Color(0xffffffff)
val ColorOnBackground = Color(0xff000000)
val ColorOnSurface = Color(0xff000000)
val ColorOnError = Color(0xffffffff)

// dark
val ColorDarkPrimary = Color(0xff305500)
val ColorDarkPrimaryVariant = Color(0xff173300)

val ColorDarkSecondary = Color(0xff200055)
val ColorDarkSecondaryVariant = Color(0xff0c0033)

val ColorDarkBackground = Color(0xff000000)
val ColorDarkSurface = Color(0xff222222)
val ColorDarkError = Color(0xffcc4444)

val ColorDarkOnPrimary = Color(0xffeeeeee)
val ColorDarkOnSecondary = Color(0xffeeeeee)
val ColorDarkOnBackground = Color(0xffeeeeee)
val ColorDarkOnSurface = Color(0xffeeeeee)
val ColorDarkOnError = Color(0xff000000)

@Composable
fun barBackgroundColor(darkTheme: Boolean = isSystemInDarkTheme()) = if (darkTheme) {
    MaterialTheme.colors.background
} else {
    MaterialTheme.colors.primary
}
