package net.uniiva.view_model.board.fragment.show

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job
import net.uniiva.entity.Answer
import net.uniiva.entity.Board
import org.koin.core.component.KoinComponent

abstract class ShowViewModelBase : ViewModel(), KoinComponent {

    abstract var board: Board?

    abstract var answers: MutableList<Answer>

    abstract suspend fun setBoardId(boardId: String): Job

    abstract fun setObserver(
        viewLifecycleOwner: LifecycleOwner,
        boardFunc: (Board) -> Unit,
        answersFunc: (MutableList<Answer>) -> Unit
    )
}