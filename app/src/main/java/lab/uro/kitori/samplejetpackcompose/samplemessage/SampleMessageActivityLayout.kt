package lab.uro.kitori.samplejetpackcompose.samplemessage

import android.widget.Toast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarData
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        "Sample Message",
        backIconOnClick
    ) {
        val showDialog = remember { mutableStateOf(false) }
        val showSnackBar = remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp, 32.dp)
        ) {
            Button(onClick = {
                showDialog.value = true
            }) {
                Text("Dialog")
            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                showSnackBar.value = true
            }) {
                Text("SnackBar")
            }
        }

        if (showDialog.value) {
            ShowDialog(showDialog)
        }
        if (showSnackBar.value) {
            ShowSnackBar(showSnackBar)
        }
    }
}

@Composable
fun ShowDialog(showDialog: MutableState<Boolean>) {
    val context = LocalContext.current

    AlertDialog(
        onDismissRequest = {
            // nothing
        },
        title = { Text("titlet") },
        text = { Text("messagemessagemessagemessagemessagemessagemessagemessage") },
        buttons = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                TextButton(
                    onClick = {
                        showDialog.value = false
                        Toast.makeText(context, "click ignore", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.align(Alignment.TopStart)
                ) {
                    Text("ignore")
                }

                Row(
                    modifier = Modifier.align(Alignment.TopEnd)
                ) {
                    TextButton(
                        onClick = {
                            showDialog.value = false
                            Toast.makeText(context, "click cancel", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Text("cancel")
                    }
                    TextButton(
                        onClick = {
                            showDialog.value = false
                            Toast.makeText(context, "click ok", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Text("ok")
                    }
                }
            }
        }

        // confirmButton, dismissButtonだけの場合はbuttonsの代わりに使える
//        confirmButton = {
//            TextButton(onClick = {
//                showDialog.value = false
//                Toast.makeText(context, "click ok", Toast.LENGTH_SHORT).show()
//            }) {
//                Text("ok")
//            }
//        },
//        dismissButton = {
//            TextButton(onClick = {
//                showDialog.value = false
//                Toast.makeText(context, "click cancel", Toast.LENGTH_SHORT).show()
//            }) {
//                Text("cancel")
//            }
//        }
    )
}

@Composable
fun ShowSnackBar(showSnackBar: MutableState<Boolean>) {
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Snackbar(
            snackbarData = object : SnackbarData {
                override val message: String
                    get() = "messagemessagemessagemessagemessagemessage"
                override val actionLabel: String
                    get() = "act"
                override val duration: SnackbarDuration
                    get() = SnackbarDuration.Short

                override fun dismiss() {
                    showSnackBar.value = false
                }

                override fun performAction() {
                    showSnackBar.value = false
                    Toast.makeText(context, "click action", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}
