package lab.uro.kitori.samplejetpackcompose.main

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lab.uro.kitori.samplecore.screen.AppScreen

@Preview
@Composable
fun PreviewLayoutLight() {
    MainActivityScreen(false)
}

@Preview
@Composable
fun PreviewLayoutDark() {
    MainActivityScreen(true)
}

@Composable
fun MainActivityScreen(
    darkTheme: Boolean = isSystemInDarkTheme(),
    sampleViewModelButtonOnClick: () -> Unit = {},
    sampleImageButtonOnClick: () -> Unit = {},
    sampleListButtonOnClick: () -> Unit = {},
    sampleNavigationButtonOnClick: () -> Unit = {},
    sampleTabButtonOnClick: () -> Unit = {},
    sampleDrawerButtonOnClick: () -> Unit = {},
    sampleConstraintButtonOnClick: () -> Unit = {},
    sampleMessageButtonOnClick: () -> Unit = {},
    sampleBottomSheetButtonOnClick: () -> Unit = {},
    sampleFabButtonOnClick: () -> Unit = {},
    sampleAndroidViewButtonOnClick: () -> Unit = {}
) {
    AppScreen(darkTheme, "Main") {
        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(32.dp)
        ) {
            Button(
                onClick = sampleViewModelButtonOnClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sample ViewModel")
            }
            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = sampleImageButtonOnClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sample Image")
            }
            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = sampleListButtonOnClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sample List")
            }
            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = sampleNavigationButtonOnClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sample Navigation")
            }
            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = sampleTabButtonOnClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sample Tab")
            }
            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = sampleDrawerButtonOnClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sample Drawer")
            }
            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = sampleConstraintButtonOnClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sample Constraint")
            }
            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = sampleMessageButtonOnClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sample Message")
            }
            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = sampleBottomSheetButtonOnClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sample BottomSheet")
            }
            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = sampleFabButtonOnClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sample FAB")
            }
            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = sampleAndroidViewButtonOnClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sample AndroidView")
            }
        }
    }
}
