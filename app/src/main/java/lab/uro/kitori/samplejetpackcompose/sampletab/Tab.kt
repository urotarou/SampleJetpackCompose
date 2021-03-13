package lab.uro.kitori.samplejetpackcompose.sampletab

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddPhotoAlternate
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Link
import androidx.compose.ui.graphics.vector.ImageVector

enum class Tab(
    val tabName: String,
    val icon: ImageVector
) {
    PHOTO("photo", Icons.Default.AddPhotoAlternate),
    COMMENT("comment", Icons.Default.Home),
    LINK("link", Icons.Default.Link),
}
