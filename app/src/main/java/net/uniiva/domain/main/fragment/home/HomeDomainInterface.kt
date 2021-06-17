package net.uniiva.domain.main.fragment.home

import net.uniiva.entity.Board
import org.koin.core.component.KoinComponent

interface HomeDomainInterface : KoinComponent{

    //現在出ている質問を表示する関数
    suspend fun getBoards(): MutableList<Board>
}