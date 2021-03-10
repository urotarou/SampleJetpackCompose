package lab.uro.kitori.samplejetpackcompose.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import lab.uro.kitori.samplejetpackcompose.sampleimage.SampleImageActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenLayout {
                startActivity(SampleImageActivity.createIntent(this))
            }
        }
    }
}
