package net.uniiva.domain.main.fragment.home

import net.uniiva.model.main.fragment.home.Board
import net.uniiva.repository.main.fragment.home.HomeRepositoryInterface
import org.koin.core.component.inject

class HomeDomain : HomeDomainInterface {

    private val homeRepository by inject<HomeRepositoryInterface>()

    //現在出ている問題を取得する関数
    override fun getBoards(): MutableList<Board>{
        return homeRepository.getBoards()
    }
}