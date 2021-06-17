package net.uniiva.repository.answer

import net.uniiva.entity.Answer
import java.util.*

class AnswerRepository : AnswerRepositoryInterface {

    //回答の仮のデータ
    private val answers = mutableListOf(
        Answer(UUID.randomUUID().toString(), "1", "test1"),
        Answer(UUID.randomUUID().toString(), "1", "test2")
    )

    //与えられた質問IDに対する回答を探す関数
    override suspend fun getAnswersByBoardId(boardId: String): MutableList<Answer> {
        return answers.filter { it.boardId == boardId }.toMutableList()
    }

    //回答を作成する関数
    override suspend fun createAnswer(answer: Answer) {
        answers.add(answer)
    }
}