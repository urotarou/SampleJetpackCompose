package lab.uro.kitori.samplejetpackcompose.sampleconstraint

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
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
        "Sample Constraint",
        backIconOnClick
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth()
        ) {
            val (text1, text2, text3, text4, text5) = createRefs()

            Text(
                "hoge 1",
                modifier = Modifier.constrainAs(text1) {
                    linkTo(
                        parent.start, parent.top, parent.end, text2.top,
                        16.dp, 16.dp, 16.dp, 8.dp
                    )
                },
                color = Color.Red
            )
            Text(
                "hoge 2",
                modifier = Modifier.constrainAs(text2) {
                    linkTo(
                        parent.start, text1.bottom, text3.start, text4.top,
                        16.dp, 8.dp, 8.dp, 8.dp
                    )
                },
                color = Color.Green
            )
            Text(
                "hoge 3",
                modifier = Modifier.constrainAs(text3) {
                    linkTo(
                        text2.end, text2.top, parent.end, text2.bottom,
                        8.dp, 8.dp, 16.dp, 8.dp
                    )
                },
                color = Color.Blue
            )
            Text(
                "hoge 4",
                modifier = Modifier.constrainAs(text4) {
                    linkTo(
                        parent.start, text2.bottom, parent.end, text4.top,
                        16.dp, 8.dp, 16.dp, 8.dp
                    )
                },
                color = Color.Yellow
            )
            Text(
                "hoge 5",
                modifier = Modifier.constrainAs(text5) {
                    linkTo(
                        parent.start, text4.bottom, parent.end, parent.bottom,
                        16.dp, 8.dp, 16.dp, 16.dp
                    )
                },
                color = Color.Magenta
            )
        }
    }
}
