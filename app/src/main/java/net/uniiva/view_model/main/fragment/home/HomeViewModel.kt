package net.uniiva.view_model.main.fragment.home

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.uniiva.domain.main.fragment.home.HomeDomainInterface
import net.uniiva.entity.Board
import org.koin.core.component.inject

class HomeViewModel : HomeViewModelBase(){

    private val homeDomain by inject<HomeDomainInterface>()

    private val _boards: MutableLiveData<MutableList<Board>> = MutableLiveData()
    override var boards: MutableList<Board>
        get() = _boards.value ?: mutableListOf()
        set(value) { _boards.postValue(value) }

    init {
        viewModelScope.launch {
            boards = homeDomain.getBoards()
        }
    }

    //_boardsを監視対象にするための関数
    override fun setObserver(
        viewLifecycleOwner: LifecycleOwner,
        func: (MutableList<Board>) -> Unit
    ){
        _boards.observe(viewLifecycleOwner, func)
    }
}