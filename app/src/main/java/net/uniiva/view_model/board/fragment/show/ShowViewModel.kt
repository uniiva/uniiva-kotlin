package net.uniiva.view_model.board.fragment.show

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.uniiva.domain.board.fragment.show.ShowDomainInterface
import net.uniiva.entity.Answer
import net.uniiva.entity.Board
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

    private val _answers = MutableLiveData<MutableList<Answer>>()

    override var answers: MutableList<Answer>
        get() = _answers.value ?: mutableListOf()
        set(value) = _answers.postValue(value)

    override suspend fun setBoardId(boardId: String) = viewModelScope.launch {
        board = showDomain.findBoardOrNull(boardId)
        answers = showDomain.getAnswersByBoardId(boardId)
    }

    //_boardsを監視対象にするための関数
    override fun setObserver(
        viewLifecycleOwner: LifecycleOwner,
        boardFunc: (Board) -> Unit,
        answersFunc: (MutableList<Answer>) -> Unit
    ){
        _board.observe(viewLifecycleOwner, boardFunc)
        _answers.observe(viewLifecycleOwner, answersFunc)
    }
}