package net.uniiva.repository.board

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.uniiva.entity.Board
import java.util.*

class BoardRepository : BoardRepositoryInterface {

    //質問の仮のデータ
    private val boards = mutableListOf(
        Board("1", "TITLE1", "CONTENTS1"),
        Board(UUID.randomUUID().toString(), "TITLE2", "CONTENTS2"),
        Board(UUID.randomUUID().toString(), "TITLE3", "CONTENTS3"),
        Board(UUID.randomUUID().toString(), "TITLE4", "CONTENTS4")
    )

    //現在出ている質問を取得する関数
    override suspend fun getBoards(): MutableList<Board> = withContext(Dispatchers.IO) {
        return@withContext boards
    }

    //渡されたIDを持つ質問を取得する関数
    override suspend fun findBoardOrNull(boardId: String): Board? = withContext(Dispatchers.IO){
        return@withContext boards.firstOrNull { it.id == boardId }
    }

    //質問を登録する関数
    override suspend fun createBoard(board: Board): Boolean = withContext(Dispatchers.IO){
        boards.add(board)
    }
}