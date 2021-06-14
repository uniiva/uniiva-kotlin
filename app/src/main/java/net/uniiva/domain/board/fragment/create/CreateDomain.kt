package net.uniiva.domain.board.fragment.create

import kotlinx.coroutines.coroutineScope
import net.uniiva.model.share.Board
import net.uniiva.repository.firebase.BoardRepositoryInterface
import org.koin.core.component.inject
import java.util.UUID

class CreateDomain : CreateDomainInterface {

    private val boardRepository: BoardRepositoryInterface by inject()

    override suspend fun createBoard(board: Board): Boolean = coroutineScope {

        board.id = createId()
        boardRepository.createBoard(board)
    }

    private fun createId(): String{
        return UUID.randomUUID().toString()
    }
}