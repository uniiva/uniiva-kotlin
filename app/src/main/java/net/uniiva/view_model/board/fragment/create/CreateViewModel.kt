package net.uniiva.view_model.board.fragment.create

import androidx.lifecycle.MutableLiveData
import net.uniiva.model.share.Board

class CreateViewModel : CreateViewModelBase() {

    private val _board = MutableLiveData<Board>()

    override var board: Board
        get() = _board.value ?: Board("", "", "")
        set(value) { _board.postValue(value) }

    init {
        board = Board("", "", "")
    }
}