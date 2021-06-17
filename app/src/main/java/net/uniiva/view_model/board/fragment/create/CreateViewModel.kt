package net.uniiva.view_model.board.fragment.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.uniiva.domain.board.fragment.create.CreateDomainInterface
import net.uniiva.entity.Board
import org.koin.core.component.inject

class CreateViewModel : CreateViewModelBase() {

    private val _board = MutableLiveData<Board>()

    override var board: Board
        get() = _board.value ?: Board("", "", "")
        set(value) { _board.postValue(value) }

    init {
        board = Board("", "", "")
    }

    private val createDomain: CreateDomainInterface by inject()

    override suspend fun createBoard() = viewModelScope.launch{
        createDomain.createBoard(board)
    }
}