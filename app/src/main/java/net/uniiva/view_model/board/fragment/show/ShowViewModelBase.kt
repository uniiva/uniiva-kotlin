package net.uniiva.view_model.board.fragment.show

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job
import net.uniiva.entity.Answer
import net.uniiva.entity.Board
import org.koin.core.component.KoinComponent

abstract class ShowViewModelBase : ViewModel(), KoinComponent {

    //確認している質問を保持する変数
    abstract var board: Board?

    //確認している回答を保持する変数
    abstract var answers: MutableList<Answer>

    //確認する質問を決める関数
    abstract suspend fun setBoardId(boardId: String): Job

    //LiveData変更時の処理を登録するための関数
    abstract fun setObserver(
        viewLifecycleOwner: LifecycleOwner,
        boardFunc: (Board) -> Unit,
        answersFunc: (MutableList<Answer>) -> Unit
    )
}