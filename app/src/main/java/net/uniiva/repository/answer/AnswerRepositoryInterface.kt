package net.uniiva.repository.answer

import net.uniiva.entity.Answer


interface AnswerRepositoryInterface {

    suspend fun getAnswersByBoardId(boardId: String): MutableList<Answer>

    suspend fun createAnswer(answer: Answer)
}