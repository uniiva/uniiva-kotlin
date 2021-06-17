package net.uniiva.repository.board

import net.uniiva.entity.Board

interface BoardRepositoryInterface {

    //現在出ている問題を取得する関数
    suspend fun getBoards(): MutableList<Board>

    //渡されたIDを持つ問題を取得する関数
    suspend fun findBoardOrNull(boardId: String): Board?

    //渡されたboardを登録する関数
    suspend fun createBoard(board: Board): Boolean
}