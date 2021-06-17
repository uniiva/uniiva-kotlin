package net.uniiva.domain.board.fragment.show

import net.uniiva.entity.Answer
import net.uniiva.entity.Board
import org.koin.core.component.KoinComponent

interface ShowDomainInterface : KoinComponent {

    suspend fun findBoardOrNull(boardId: String): Board?

    suspend fun getAnswersByBoardId(boardId: String): MutableList<Answer>
}