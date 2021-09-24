package lab.uro.kitori.samplejetpackcompose.sampletab

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity

class SampleTabActivity : AppCompatActivity() {
    companion object {
        fun createIntent(context: Context) = Intent(context, SampleTabActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleTabScreen(
                backIconOnClick = {
                    onBackPressed()
                },
                tab = Tab.values().toList()
            )
        }
    }
}
