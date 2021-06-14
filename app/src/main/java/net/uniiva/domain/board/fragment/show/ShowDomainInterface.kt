package net.uniiva.domain.board.fragment.show

import net.uniiva.model.share.Board
import org.koin.core.component.KoinComponent

interface ShowDomainInterface : KoinComponent {

    suspend fun findBoardOrNull(id: String): Board?
}