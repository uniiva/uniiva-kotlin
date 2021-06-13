package net.uniiva.view_model.main.fragment.home

import androidx.lifecycle.MutableLiveData
import net.uniiva.domain.main.fragment.home.HomeDomainInterface
import net.uniiva.model.main.fragment.home.Board
import org.koin.core.component.inject

class HomeViewModel : HomeViewModelBase(){

    private val homeDomain by inject<HomeDomainInterface>()

    private val _questions: MutableLiveData<MutableList<Board>> = MutableLiveData()
    override var boards: MutableList<Board>
        get() = _questions.value ?: mutableListOf()
        set(value) { _questions.postValue(value) }

    init {
        boards = homeDomain.getBoards()
    }
}