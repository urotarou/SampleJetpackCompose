package lab.uro.kitori.samplejetpackcompose.sampleviewmodel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

class SampleViewModelActivity : AppCompatActivity() {
    companion object {
        fun createIntent(context: Context) = Intent(context, SampleViewModelActivity::class.java)
    }

    private val viewModel by viewModels<SampleViewModelViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val name by viewModel.name.observeAsState("")

            ScreenLayout(
                backIconOnClick = {
                    onBackPressed()
                },
                shuffleButtonOnClick = {
                    viewModel.nextName()
                },
                name = name
            )
        }
    }
}
