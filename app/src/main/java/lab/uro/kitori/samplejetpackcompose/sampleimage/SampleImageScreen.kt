package lab.uro.kitori.samplejetpackcompose.sampleimage

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lab.uro.kitori.samplecore.screen.AppScreen
import lab.uro.kitori.samplejetpackcompose.R

@Preview
@Composable
fun PreviewSampleImageScreenLight() {
    SampleImageScreen(false)
}

@Preview
@Composable
fun PreviewSampleImageScreenDark() {
    SampleImageScreen(true)
}

@Composable
fun SampleImageScreen(
    darkTheme: Boolean = isSystemInDarkTheme(),
    backIconOnClick: () -> Unit = {}
) {
    AppScreen(
        darkTheme,
        "Sample Image",
        backIconOnClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp, 32.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painterResource(R.drawable.ic_launcher_background),
                    "sample-background",
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )
                Image(
                    painterResource(R.drawable.ic_launcher_foreground),
                    "sample-foreground",
                    modifier = Modifier.wrapContentSize()
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "hogehogehogehogehogehogehogehogehogehogehogehogehogehogehogehogehogehogehogehogehogehogehogehoge",
                style = MaterialTheme.typography.h6,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text("piyopiyo")
            Text(
                "fugafugafuga",
                style = MaterialTheme.typography.overline
            )
        }
    }
}
