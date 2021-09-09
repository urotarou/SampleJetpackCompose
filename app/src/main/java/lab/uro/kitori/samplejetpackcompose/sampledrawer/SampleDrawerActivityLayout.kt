package lab.uro.kitori.samplejetpackcompose.sampledrawer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.DrawerValue
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Text
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import lab.uro.kitori.samplecore.screen.BranchScreen

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
        "Sample Drawer",
        backIconOnClick
    ) {
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        var text by remember { mutableStateOf("close") }

        ModalDrawer(
            drawerState = drawerState,
            drawerContent = {
                Text(
                    "Hoge",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            text = "close from Hooge"
                            scope.launch { drawerState.close() }
                        }
                        .padding(16.dp)
                )
                Text(
                    "Piyo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            text = "close from Piyo"
                            scope.launch { drawerState.close() }
                        }
                        .padding(16.dp)
                )
                Text(
                    "Fuga",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            text = "close from Fuga"
                            scope.launch { drawerState.close() }
                        }
                        .padding(16.dp)
                )
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        if (drawerState.isClosed) text else "open",
                        modifier = Modifier.align(
                            if (drawerState.isClosed) Alignment.CenterHorizontally else Alignment.End
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = { scope.launch { drawerState.open() } },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text("open drawer")
                    }
                }
            }
        )
    }
}
