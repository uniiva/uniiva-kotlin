package net.uniiva.repository.main.fragment.home

import net.uniiva.model.main.fragment.home.Board
import java.util.*

class HomeRepository : HomeRepositoryInterface{

    //現在出ている問題を取得する関数
    override fun getBoards(): MutableList<Board> {
        return mutableListOf(
            Board(UUID.randomUUID().toString(), "TITLE1", "CONTENTS1"),
            Board(UUID.randomUUID().toString(), "TITLE2", "CONTENTS2"),
            Board(UUID.randomUUID().toString(), "TITLE3", "CONTENTS3"),
            Board(UUID.randomUUID().toString(), "TITLE4", "CONTENTS4")
        )
    }

}