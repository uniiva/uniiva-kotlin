package net.uniiva.view_model.board.fragment.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.uniiva.domain.board.fragment.create.CreateDomainInterface
import net.uniiva.entity.Board
import org.koin.core.component.inject

class CreateViewModel : CreateViewModelBase() {

    private val createDomain: CreateDomainInterface by inject()

    //作成中の質問を保持するLiveData
    private val _board = MutableLiveData<Board>()

    override var board: Board
        get() = _board.value ?: Board("", "", "")
        set(value) { _board.postValue(value) }

    init {
        board = Board(createDomain.createId(), "", "")
    }

    //質問を作成する関数
    override suspend fun createBoard() = viewModelScope.launch{
        createDomain.createBoard(board)
    }
}