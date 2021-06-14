package net.uniiva.domain.board.fragment.create

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import net.uniiva.model.share.Board
import net.uniiva.repository.firebase.BoardRepositoryInterface
import org.koin.core.component.inject

class CreateDomain : CreateDomainInterface {

    private val boardRepository: BoardRepositoryInterface by inject()

    override suspend fun createBoard(board: Board): Boolean = coroutineScope {
        boardRepository.createBoard(board)
    }
}