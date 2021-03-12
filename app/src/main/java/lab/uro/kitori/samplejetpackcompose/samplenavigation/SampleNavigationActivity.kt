package lab.uro.kitori.samplejetpackcompose.samplenavigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity

class SampleNavigationActivity : AppCompatActivity() {
    companion object {
        fun createIntent(context: Context) = Intent(context, SampleNavigationActivity::class.java)
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
