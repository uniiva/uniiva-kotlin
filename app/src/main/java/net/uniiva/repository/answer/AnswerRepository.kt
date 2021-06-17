package net.uniiva.repository.answer

import net.uniiva.entity.Answer
import java.util.*

class AnswerRepository : AnswerRepositoryInterface {

    private val answers = mutableListOf(
        Answer(UUID.randomUUID().toString(), "1", "test1"),
        Answer(UUID.randomUUID().toString(), "1", "test2")
    )

    override suspend fun getAnswersByBoardId(boardId: String): MutableList<Answer> {
        return answers.filter { it.boardId == boardId }.toMutableList()
    }

    override suspend fun createAnswer(answer: Answer) {
        answers.add(answer)
    }
}