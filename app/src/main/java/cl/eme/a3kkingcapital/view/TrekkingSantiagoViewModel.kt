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
    private val selected = MutableLiveData<List<TrekkingSantiago>>()
    fun selected(): MutableLiveData<List<TrekkingSantiago>> = selected


    init {
        viewModelScope.launch {
            repository.getTrekkingRoutes()
        }
        fun selected(trekking: TrekkingSantiago){
            selected.value = listOf(trekking)
        }

    }


}