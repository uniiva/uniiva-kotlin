package net.uniiva.repository.firebase

import net.uniiva.model.share.Board
import java.util.*

class BoardRepository : BoardRepositoryInterface {

    private val boards = mutableListOf(
        Board(UUID.randomUUID().toString(), "TITLE1", "CONTENTS1"),
        Board(UUID.randomUUID().toString(), "TITLE2", "CONTENTS2"),
        Board(UUID.randomUUID().toString(), "TITLE3", "CONTENTS3"),
        Board(UUID.randomUUID().toString(), "TITLE4", "CONTENTS4")
    )

    //現在出ている問題を取得する関数
    override fun getBoards(): MutableList<Board> {
        return boards
    }

    override fun createBoard(board: Board){
        boards.add(board)
    }

}