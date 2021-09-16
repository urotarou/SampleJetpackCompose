package lab.uro.kitori.samplejetpackcompose.sampleandroidview

import android.webkit.WebView
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import lab.uro.kitori.samplecore.screen.AppScreen

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
    AppScreen(
        darkTheme,
        "Sample AndroidView",
        backIconOnClick
    ) {
        WebView("https://github.com/urotarou/SampleJetpackCompose/blob/master/app/src/main/java/lab/uro/kitori/samplejetpackcompose/sampleandroidview/SampleAndroidViewScreen.kt")
    }
}

@Composable
fun WebView(url: String) {
    AndroidView(
        factory = { WebView(it) },
        modifier = Modifier.fillMaxSize()
    ) {
        it.loadUrl(url)
    }
}