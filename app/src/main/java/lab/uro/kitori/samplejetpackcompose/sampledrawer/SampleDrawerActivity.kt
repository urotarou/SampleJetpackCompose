package lab.uro.kitori.samplejetpackcompose.sampledrawer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity

class SampleDrawerActivity : AppCompatActivity() {
    companion object {
        fun createIntent(context: Context) = Intent(context, SampleDrawerActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenLayout {
                onBackPressed()
            }
        }
    }
}
