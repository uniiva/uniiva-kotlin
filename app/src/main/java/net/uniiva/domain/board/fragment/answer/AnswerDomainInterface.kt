package net.uniiva.domain.board.fragment.answer

import net.uniiva.entity.Answer
import org.koin.core.component.KoinComponent

interface AnswerDomainInterface : KoinComponent {

    //回答を作成する関数
    suspend fun createAnswer(answer: Answer)

    //ユニークIDを作成する関数
    fun createId(): String
}