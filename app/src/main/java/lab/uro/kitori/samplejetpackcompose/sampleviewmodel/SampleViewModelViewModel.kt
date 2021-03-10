package lab.uro.kitori.samplejetpackcompose.sampleviewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SampleViewModelViewModel(
    app: Application
) : AndroidViewModel(app) {
    private val source = listOf(
        "yuuna",
        "mimori",
        "fuu",
        "itsuki",
        "karin",
        "sonoko"
    )

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    fun nextName() = viewModelScope.launch {
        val old = _name.value
        _name.value = source.shuffled().find { it != old }
    }
}
