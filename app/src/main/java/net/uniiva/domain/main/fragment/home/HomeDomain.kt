package net.uniiva.domain.main.fragment.home

import net.uniiva.model.share.Board
import net.uniiva.repository.firebase.BoardRepositoryInterface
import org.koin.core.component.inject

class HomeDomain : HomeDomainInterface {

    private val boardRepository by inject<BoardRepositoryInterface>()

    //現在出ている問題を取得する関数
    override fun getBoards(): MutableList<Board>{
        return boardRepository.getBoards()
    }
}