package lab.uro.kitori.samplejetpackcompose.samplefab

import android.widget.Toast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lab.uro.kitori.samplecore.screen.AppScreen

@Preview
@Composable
fun PreviewSampleFabScreenLight() {
    SampleFabScreen(false)
}

@Preview
@Composable
fun PreviewSampleFabScreenDark() {
    SampleFabScreen(true)
}

@Composable
fun SampleFabScreen(
    darkTheme: Boolean = isSystemInDarkTheme(),
    backIconOnClick: () -> Unit = {}
) {
    val context = LocalContext.current

    AppScreen(
        darkTheme,
        "Sample FAB",
        backIconOnClick
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                "FAB",
                modifier = Modifier.align(Alignment.Center)
            )

            FloatingActionButton(
                modifier = Modifier
                    .align(alignment = Alignment.BottomEnd)
                    .padding(0.dp, 0.dp, 16.dp, 16.dp),
                onClick = {
                    Toast.makeText(context, "click fab", Toast.LENGTH_SHORT).show()
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "fab")
            }
        }
    }
}
