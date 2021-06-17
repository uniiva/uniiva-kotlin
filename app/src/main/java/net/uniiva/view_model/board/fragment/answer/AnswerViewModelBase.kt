package net.uniiva.view_model.board.fragment.answer

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job
import net.uniiva.entity.Answer
import org.koin.core.component.KoinComponent

abstract class AnswerViewModelBase: ViewModel(), KoinComponent {

    abstract var answer: Answer

    abstract suspend fun createAnswer(boardId: String): Job
}