package net.uniiva.repository.main.fragment.home

import net.uniiva.model.share.Board
import java.util.*

class HomeRepository : HomeRepositoryInterface{

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

}