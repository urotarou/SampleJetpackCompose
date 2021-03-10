package lab.uro.kitori.samplejetpackcompose.samplelist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class SampleListActivity : AppCompatActivity() {
    companion object {
        fun createIntent(context: Context) = Intent(context, SampleListActivity::class.java)
    }

    private val viewModel by viewModels<SampleListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenLayout(
                viewModel = viewModel,
                backIconOnClick = {
                    onBackPressed()
                },
                loadButtonOnClick = {
                    viewModel.load()
                }
            )
        }
    }
}
