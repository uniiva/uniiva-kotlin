package net.uniiva.domain.board.fragment.create

import net.uniiva.entity.Board
import org.koin.core.component.KoinComponent

interface CreateDomainInterface : KoinComponent{

    suspend fun createBoard(board: Board): Boolean
}