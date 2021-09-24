package lab.uro.kitori.samplejetpackcompose.samplelist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

class SampleListActivity : AppCompatActivity() {
    companion object {
        fun createIntent(context: Context) = Intent(context, SampleListActivity::class.java)
    }

    private val viewModel by viewModels<SampleListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val items by viewModel.items.observeAsState(listOf())
            val isLoading by viewModel.isLoading.observeAsState(false)

            SampleListScreen(
                backIconOnClick = {
                    onBackPressed()
                },
                loadButtonOnClick = {
                    viewModel.load()
                },
                items = items,
                isLoading = isLoading
            )
        }
    }
}
