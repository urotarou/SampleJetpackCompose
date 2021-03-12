package lab.uro.kitori.samplejetpackcompose.samplenavigation.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddPhotoAlternate
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Link
import androidx.compose.ui.graphics.vector.ImageVector

enum class Screen(
    val route: String,
    val icon: ImageVector,
    val label: String
) {
    HOME("route-home", Icons.Default.Home, "home"),
    PHOTO("route-photo", Icons.Default.AddPhotoAlternate, "photo"),
    COMMENT("route-comment", Icons.Default.Home, "comment"),
    LINK("route-link", Icons.Default.Link, "link"),
}
