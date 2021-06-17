package net.uniiva.domain.board.fragment.show

import kotlinx.coroutines.coroutineScope
import net.uniiva.entity.Answer
import net.uniiva.entity.Board
import net.uniiva.repository.answer.AnswerRepositoryInterface
import net.uniiva.repository.board.BoardRepositoryInterface
import org.koin.core.component.inject

class ShowDomain : ShowDomainInterface {

    private val boardRepository: BoardRepositoryInterface by inject()
    private val answerRepository: AnswerRepositoryInterface by inject()

    //与えられたIDの質問を探す関数
    override suspend fun findBoardOrNull(boardId: String): Board? = coroutineScope {
        return@coroutineScope boardRepository.findBoardOrNull(boardId)
    }

    //与えられた質問IDに対する回答を探す関数
    override suspend fun getAnswersByBoardId(boardId: String): MutableList<Answer> = coroutineScope {
        answerRepository.getAnswersByBoardId(boardId)
    }
}