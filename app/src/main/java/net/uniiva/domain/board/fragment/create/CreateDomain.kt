package net.uniiva.domain.board.fragment.create

import kotlinx.coroutines.coroutineScope
import net.uniiva.entity.Board
import net.uniiva.repository.board.BoardRepositoryInterface
import org.koin.core.component.inject
import java.util.UUID

class CreateDomain : CreateDomainInterface {

    private val boardRepository: BoardRepositoryInterface by inject()

    //質問を作成する関数
    override suspend fun createBoard(board: Board): Boolean = coroutineScope {
        boardRepository.createBoard(board)
    }

    //ユニークIDを作成する関数
    override fun createId(): String{
        return UUID.randomUUID().toString()
    }
}