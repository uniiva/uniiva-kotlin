package net.uniiva.domain.board.fragment.create

import net.uniiva.entity.Board
import org.koin.core.component.KoinComponent

interface CreateDomainInterface : KoinComponent{

    //質問を作成する関数
    suspend fun createBoard(board: Board): Boolean

    //ユニークIDを作成する関数
    fun createId(): String
}