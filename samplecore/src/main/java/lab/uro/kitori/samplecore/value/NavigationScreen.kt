package lab.uro.kitori.samplecore.value

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationScreen(
    val key: String,
    val icon: ImageVector,
    @StringRes val labelResId: Int,
    val description: String = key,
    val composableScreen: @Composable () -> Unit
)
