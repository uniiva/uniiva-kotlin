package net.uniiva.view_model.board.fragment.create

import androidx.lifecycle.MutableLiveData
import net.uniiva.domain.board.fragment.create.CreateDomainInterface
import net.uniiva.model.share.Board
import org.koin.core.component.inject
import java.util.*

class CreateViewModel : CreateViewModelBase() {

    private val _board = MutableLiveData<Board>()

    override var board: Board
        get() = _board.value ?: Board("", "", "")
        set(value) { _board.postValue(value) }

    init {
        board = Board(UUID.randomUUID().toString(), "", "")
    }

    private val createDomain: CreateDomainInterface by inject()

    override fun createBoard(){
        createDomain.createBoard(board)
    }
}