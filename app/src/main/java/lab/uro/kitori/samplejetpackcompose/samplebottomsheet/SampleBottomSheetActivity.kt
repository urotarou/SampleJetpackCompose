package lab.uro.kitori.samplejetpackcompose.samplebottomsheet

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.ExperimentalMaterialApi

class SampleBottomSheetActivity : AppCompatActivity() {
    companion object {
        fun createIntent(context: Context) = Intent(context, SampleBottomSheetActivity::class.java)
    }

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenLayout {
                onBackPressed()
            }
        }
    }
}
