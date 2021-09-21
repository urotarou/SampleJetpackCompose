package lab.uro.kitori.samplejetpackcompose.samplebottomsheet

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import lab.uro.kitori.samplecore.screen.AppScreen

@Preview
@Composable
fun PreviewSampleBottomSheetScreenLight() {
    SampleBottomSheetScreen(false)
}

@Preview
@Composable
fun PreviewSampleBottomSheetScreenDark() {
    SampleBottomSheetScreen(true)
}

@Composable
fun SampleBottomSheetScreen(
    darkTheme: Boolean = isSystemInDarkTheme(),
    backIconOnClick: () -> Unit = {}
) {
    AppScreen(
        darkTheme,
        "Sample BottomSheet",
        backIconOnClick
    ) {
        val currentBottomSheetIndex = remember { mutableStateOf(0) }
        val scope = rememberCoroutineScope()

        when (currentBottomSheetIndex.value) {
            1 -> BottomSheetA(scope, currentBottomSheetIndex)
            2 -> BottomSheetB(scope, currentBottomSheetIndex)
            else -> BaseLayout(currentBottomSheetIndex)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetA(
    scope: CoroutineScope,
    currentBottomSheetIndex: MutableState<Int>
) {
    val context = LocalContext.current
    val sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)

    ModalBottomSheetLayout(
        sheetContent = {
            Text(
                "Hoge A",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        scope.launch { sheetState.hide() }
                        Toast
                            .makeText(context, "click Hoge A", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .padding(8.dp)
            )
            Text(
                "Piyo A",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        scope.launch { sheetState.hide() }
                        Toast
                            .makeText(context, "click Piyo A", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .padding(8.dp)
            )
            Text(
                "Fuga A",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        scope.launch { sheetState.hide() }
                        Toast
                            .makeText(context, "click Fuga A", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .padding(8.dp)
            )
        },
        modifier = Modifier.fillMaxWidth(),
        sheetState = sheetState
    ) {
        scope.launch { sheetState.show() }
        BaseLayout(currentBottomSheetIndex)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetB(
    scope: CoroutineScope,
    currentBottomSheetIndex: MutableState<Int>
) {
    val context = LocalContext.current
    val sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)

    ModalBottomSheetLayout(
        sheetContent = {
            Text(
                "Hoge B",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        scope.launch { sheetState.hide() }
                        Toast
                            .makeText(context, "click Hoge B", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .padding(8.dp)
            )
            Text(
                "Piyo B",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        scope.launch { sheetState.hide() }
                        Toast
                            .makeText(context, "click Piyo B", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .padding(8.dp)
            )
            Text(
                "Fuga B",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        scope.launch { sheetState.hide() }
                        Toast
                            .makeText(context, "click Fuga B", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .padding(8.dp)
            )
        },
        modifier = Modifier.fillMaxWidth(),
        sheetState = sheetState
    ) {
        scope.launch { sheetState.show() }
        BaseLayout(currentBottomSheetIndex)
    }
}

@Composable
fun BaseLayout(currentBottomSheetIndex: MutableState<Int>) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center)
        ) {
            Button(
                onClick = {
                    currentBottomSheetIndex.value = 1
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("show bottom sheet A")
            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    currentBottomSheetIndex.value = 2
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("show bottom sheet B")
            }
        }
    }
}