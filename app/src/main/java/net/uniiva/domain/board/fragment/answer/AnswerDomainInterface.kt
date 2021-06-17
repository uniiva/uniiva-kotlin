package net.uniiva.domain.board.fragment.answer

import net.uniiva.entity.Answer
import org.koin.core.component.KoinComponent

interface AnswerDomainInterface : KoinComponent {

    suspend fun createAnswer(answer: Answer)
}