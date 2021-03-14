package lab.uro.kitori.samplejetpackcompose.sampleconstraint

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity

class SampleConstraintActivity : AppCompatActivity() {
    companion object {
        fun createIntent(context: Context) = Intent(context, SampleConstraintActivity::class.java)
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
