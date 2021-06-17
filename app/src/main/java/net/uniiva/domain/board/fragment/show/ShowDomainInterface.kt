package net.uniiva.domain.board.fragment.show

import net.uniiva.entity.Answer
import net.uniiva.entity.Board
import org.koin.core.component.KoinComponent

interface ShowDomainInterface : KoinComponent {

    //与えられたIDの質問を探す関数
    suspend fun findBoardOrNull(boardId: String): Board?

    //与えられた質問IDに対する返信を探す関数
    suspend fun getAnswersByBoardId(boardId: String): MutableList<Answer>
}