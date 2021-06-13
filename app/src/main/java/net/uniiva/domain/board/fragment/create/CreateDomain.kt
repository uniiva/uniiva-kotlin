package net.uniiva.domain.board.fragment.create

import net.uniiva.model.share.Board
import net.uniiva.repository.firebase.BoardRepositoryInterface
import org.koin.core.component.inject

class CreateDomain : CreateDomainInterface {

    private val boardRepository: BoardRepositoryInterface by inject()

    override fun createBoard(board: Board){
        boardRepository.createBoard(board)
    }
}