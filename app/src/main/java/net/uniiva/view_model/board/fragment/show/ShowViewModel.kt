package net.uniiva.view_model.board.fragment.show

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.uniiva.domain.board.fragment.show.ShowDomainInterface
import net.uniiva.model.share.Board
import net.uniiva.repository.firebase.BoardRepositoryInterface
import org.koin.core.component.inject

class ShowViewModel : ShowViewModelBase() {

    private val showDomain: ShowDomainInterface by inject()

    private val _board = MutableLiveData<Board>()

    override var board: Board?
        get() = _board.value
        set(value) {
            value?.let {
                _board.postValue(it)
            }
        }

    override suspend fun setBoard(id: String) = viewModelScope.launch {
        board = showDomain.findBoardOrNull(id)
    }

    //_boardsを監視対象にするための関数
    override fun setObserver(
        viewLifecycleOwner: LifecycleOwner,
        func: (Board) -> Unit
    ){
        _board.observe(viewLifecycleOwner, func)
    }
}