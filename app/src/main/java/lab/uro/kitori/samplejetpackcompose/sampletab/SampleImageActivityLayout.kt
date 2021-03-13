package lab.uro.kitori.samplejetpackcompose.sampletab

import android.widget.Toast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lab.uro.kitori.samplejetpackcompose.compose.ui.BranchScreen

@Preview
@Composable
fun PreviewLayoutLight() {
    ScreenLayout(
        darkTheme = false,
        tab = Tab.values().toList()
    )
}

@Preview
@Composable
fun PreviewLayoutDark() {
    ScreenLayout(
        darkTheme = true,
        tab = Tab.values().toList()
    )
}

@Composable
fun ScreenLayout(
    darkTheme: Boolean = isSystemInDarkTheme(),
    backIconOnClick: () -> Unit = {},
    tab: List<Tab> = listOf()
) {
    BranchScreen(
        darkTheme,
        "Sample Tab",
        backIconOnClick
    ) {
        val context = LocalContext.current

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            var currentTab by remember { mutableStateOf(Tab.PHOTO) }

            TabRow(
                selectedTabIndex = Tab.valueOf(currentTab.name).ordinal,
                modifier = Modifier.fillMaxWidth()
            ) {
                tab.forEach {
                    Tab(
                        selected = it.tabName == currentTab.tabName,
                        onClick = {
                            currentTab = it
                            Toast.makeText(
                                context,
                                "click ${it.tabName}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    ) {
                        Icon(imageVector = it.icon, contentDescription = "func")
                        Text(it.tabName)
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp, 32.dp)
            ) {
                Text(
                    currentTab.tabName,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}
