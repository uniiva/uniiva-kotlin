package net.uniiva.repository.answer

import net.uniiva.entity.Answer


interface AnswerRepositoryInterface {

    //与えられた質問IDに対する回答を探す関数
    suspend fun getAnswersByBoardId(boardId: String): MutableList<Answer>

    //回答を作成する関数
    suspend fun createAnswer(answer: Answer)
}