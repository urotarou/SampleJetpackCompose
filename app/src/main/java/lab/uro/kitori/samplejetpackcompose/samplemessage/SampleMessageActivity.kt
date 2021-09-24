package lab.uro.kitori.samplejetpackcompose.samplemessage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity

class SampleMessageActivity : AppCompatActivity() {
    companion object {
        fun createIntent(context: Context) = Intent(context, SampleMessageActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleMessageScreen {
                onBackPressed()
            }
        }
    }
}
