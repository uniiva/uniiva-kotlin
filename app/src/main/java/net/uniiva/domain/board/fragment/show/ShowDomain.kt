package net.uniiva.domain.board.fragment.show

import kotlinx.coroutines.coroutineScope
import net.uniiva.model.share.Board
import net.uniiva.repository.firebase.BoardRepositoryInterface
import org.koin.core.component.inject

class ShowDomain : ShowDomainInterface {

    private val boardRepository: BoardRepositoryInterface by inject()

    override suspend fun findBoardOrNull(id: String): Board? = coroutineScope {
        return@coroutineScope boardRepository.findBoardOrNull(id)
    }
}