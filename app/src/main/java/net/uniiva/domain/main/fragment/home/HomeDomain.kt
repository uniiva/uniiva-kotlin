package net.uniiva.domain.main.fragment.home

import kotlinx.coroutines.coroutineScope
import net.uniiva.entity.Board
import net.uniiva.repository.board.BoardRepositoryInterface
import org.koin.core.component.inject

class HomeDomain : HomeDomainInterface {

    private val boardRepository by inject<BoardRepositoryInterface>()

    //現在出ている問題を取得する関数
    override suspend fun getBoards(): MutableList<Board> = coroutineScope {
        return@coroutineScope boardRepository.getBoards()
    }
}