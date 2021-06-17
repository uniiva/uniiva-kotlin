package net.uniiva.domain.board.fragment.answer

import kotlinx.coroutines.coroutineScope
import net.uniiva.entity.Answer
import net.uniiva.repository.answer.AnswerRepositoryInterface
import org.koin.core.component.inject

class AnswerDomain : AnswerDomainInterface{

    private val answerRepository: AnswerRepositoryInterface by inject()

    override suspend fun createAnswer(answer: Answer) = coroutineScope{
        answerRepository.createAnswer(answer)
    }
}