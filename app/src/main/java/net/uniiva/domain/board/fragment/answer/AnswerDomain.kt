package net.uniiva.domain.board.fragment.answer

import kotlinx.coroutines.coroutineScope
import net.uniiva.entity.Answer
import net.uniiva.repository.answer.AnswerRepositoryInterface
import org.koin.core.component.inject
import java.util.*

class AnswerDomain : AnswerDomainInterface{

    private val answerRepository: AnswerRepositoryInterface by inject()

    //回答を作成する関数
    override suspend fun createAnswer(answer: Answer) = coroutineScope{
        answerRepository.createAnswer(answer)
    }

    //ユニークIDを作成する関数
    override fun createId(): String{
        return UUID.randomUUID().toString()
    }
}