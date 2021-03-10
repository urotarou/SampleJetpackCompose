package lab.uro.kitori.samplejetpackcompose.samplelist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SampleListViewModel(
    app: Application
) : AndroidViewModel(app) {
    private val _items = MutableLiveData<List<String>>()
    val items: LiveData<List<String>> = _items

    private val _loadingState = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _loadingState

    fun load() = viewModelScope.launch {
        _loadingState.value = true
        delay(2000)
        _loadingState.value = false

        _items.value = (0 until 100).map { "hoge $it" }
    }
}
