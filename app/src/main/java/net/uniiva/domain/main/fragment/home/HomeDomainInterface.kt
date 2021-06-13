package net.uniiva.domain.main.fragment.home

import net.uniiva.model.share.Board
import org.koin.core.component.KoinComponent

interface HomeDomainInterface : KoinComponent{

    //現在出ている問題を表示する関数
    fun getBoards(): MutableList<Board>
}