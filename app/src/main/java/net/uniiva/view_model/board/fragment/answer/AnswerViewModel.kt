package net.uniiva.view_model.board.fragment.answer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.uniiva.domain.board.fragment.answer.AnswerDomainInterface
import net.uniiva.entity.Answer
import org.koin.core.component.inject
import java.util.*

class AnswerViewModel : AnswerViewModelBase(){

    private val answerDomain: AnswerDomainInterface by inject()

    private val _answer = MutableLiveData<Answer>()
    override var answer: Answer
        get() = _answer.value ?: Answer("", "", "")
        set(value) { _answer.postValue(value) }

    init {
        answer = Answer(UUID.randomUUID().toString(), "", "")
    }

    override suspend fun createAnswer(boardId: String) = viewModelScope.launch{
        answerDomain.createAnswer(answer.copy(boardId = boardId))
    }
}