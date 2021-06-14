package net.uniiva.repository.firebase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
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
    override suspend fun getBoards(): MutableList<Board> = withContext(Dispatchers.IO) {
        return@withContext boards
    }

    //渡されたIDを持つ問題を取得する関数
    override suspend fun findBoardOrNull(id: String): Board? = withContext(Dispatchers.IO){
        return@withContext boards.firstOrNull { it.id == id }
    }

    //渡されたboardを登録する関数
    override suspend fun createBoard(board: Board): Boolean = withContext(Dispatchers.IO){
        boards.add(board)
    }
}