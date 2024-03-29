package lab.uro.kitori.samplejetpackcompose.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import lab.uro.kitori.samplejetpackcompose.sampleandroidview.SampleAndroidViewActivity
import lab.uro.kitori.samplejetpackcompose.samplebottomsheet.SampleBottomSheetActivity
import lab.uro.kitori.samplejetpackcompose.sampleconstraint.SampleConstraintActivity
import lab.uro.kitori.samplejetpackcompose.sampledrawer.SampleDrawerActivity
import lab.uro.kitori.samplejetpackcompose.samplefab.SampleFabActivity
import lab.uro.kitori.samplejetpackcompose.sampleimage.SampleImageActivity
import lab.uro.kitori.samplejetpackcompose.samplelist.SampleListActivity
import lab.uro.kitori.samplejetpackcompose.samplemessage.SampleMessageActivity
import lab.uro.kitori.samplejetpackcompose.samplenavigation.SampleNavigationActivity
import lab.uro.kitori.samplejetpackcompose.sampletab.SampleTabActivity
import lab.uro.kitori.samplejetpackcompose.sampleviewmodel.SampleViewModelActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityScreen(
                sampleViewModelButtonOnClick = {
                    startActivity(SampleViewModelActivity.createIntent(this))
                },
                sampleImageButtonOnClick = {
                    startActivity(SampleImageActivity.createIntent(this))
                },
                sampleListButtonOnClick = {
                    startActivity(SampleListActivity.createIntent(this))
                },
                sampleNavigationButtonOnClick = {
                    startActivity(SampleNavigationActivity.createIntent(this))
                },
                sampleTabButtonOnClick = {
                    startActivity(SampleTabActivity.createIntent(this))
                },
                sampleDrawerButtonOnClick = {
                    startActivity(SampleDrawerActivity.createIntent(this))
                },
                sampleConstraintButtonOnClick = {
                    startActivity(SampleConstraintActivity.createIntent(this))
                },
                sampleMessageButtonOnClick = {
                    startActivity(SampleMessageActivity.createIntent(this))
                },
                sampleBottomSheetButtonOnClick = {
                    startActivity(SampleBottomSheetActivity.createIntent(this))
                },
                sampleFabButtonOnClick = {
                    startActivity(SampleFabActivity.createIntent(this))
                },
                sampleAndroidViewButtonOnClick = {
                    startActivity(SampleAndroidViewActivity.createIntent(this))
                }
            )
        }
    }
}
