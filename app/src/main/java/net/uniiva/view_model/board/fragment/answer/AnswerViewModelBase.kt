package net.uniiva.view_model.board.fragment.answer

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job
import net.uniiva.entity.Answer
import org.koin.core.component.KoinComponent

abstract class AnswerViewModelBase: ViewModel(), KoinComponent {

    //作成中の回答を保持する変数
    abstract var answer: Answer

    //回答を作成する関数
    abstract suspend fun createAnswer(boardId: String): Job
}