package lab.uro.kitori.samplejetpackcompose.sampleimage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity

class SampleImageActivity : AppCompatActivity() {
    companion object {
        fun createIntent(context: Context) = Intent(context, SampleImageActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleImageScreen {
                onBackPressed()
            }
        }
    }
}
