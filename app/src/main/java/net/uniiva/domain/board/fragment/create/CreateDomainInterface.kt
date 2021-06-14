package net.uniiva.domain.board.fragment.create

import net.uniiva.model.share.Board
import org.koin.core.component.KoinComponent

interface CreateDomainInterface : KoinComponent{

    suspend fun createBoard(board: Board): Boolean
}