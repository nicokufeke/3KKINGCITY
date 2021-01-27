package cl.eme.a3kkingcapital.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.eme.a3kkingcapital.model.Repository
import cl.eme.a3kkingcapital.model.TrekkingSantiago
import kotlinx.coroutines.launch

class TrekkingSantiagoViewModel: ViewModel() {

    private val repository = Repository()
    private val selected = repository.trekkings
    fun selected(): LiveData<List<TrekkingSantiago>> = selected

    private val mutableLiveData = MutableLiveData<TrekkingSantiago>()
    fun selectedItem(): LiveData<TrekkingSantiago> = mutableLiveData
    fun selectedItem(trekkingSantiago: TrekkingSantiago) {
        mutableLiveData.value = trekkingSantiago
    }

    init {
        viewModelScope.launch {
            repository.getTrekkingRoutes()
        }

    }


}