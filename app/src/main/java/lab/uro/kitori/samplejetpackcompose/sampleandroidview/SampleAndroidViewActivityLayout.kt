package lab.uro.kitori.samplejetpackcompose.sampleandroidview

import android.webkit.WebView
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import lab.uro.kitori.samplejetpackcompose.compose.ui.BranchScreen

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
    BranchScreen(
        darkTheme,
        "Sample AndroidView",
        backIconOnClick
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            AndroidView(
                factory = { WebView(it) },
                modifier = Modifier.fillMaxSize()
            ) {
                it.loadUrl("https://www.google.com/")
            }
            Spacer(modifier = Modifier.height(16.dp))

            Text("show AndroidView")
        }
    }
}
