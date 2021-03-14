package lab.uro.kitori.samplejetpackcompose.sampleandroidview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity

class SampleAndroidViewActivity : AppCompatActivity() {
    companion object {
        fun createIntent(context: Context) = Intent(context, SampleAndroidViewActivity::class.java)
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
