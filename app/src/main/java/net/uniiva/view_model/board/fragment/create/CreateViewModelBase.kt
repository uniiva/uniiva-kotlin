package net.uniiva.view_model.board.fragment.create

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job
import net.uniiva.entity.Board
import org.koin.core.component.KoinComponent

abstract class CreateViewModelBase : ViewModel(), KoinComponent {

    //作成中の質問を保持する変数
    abstract var board: Board

    //質問を作成する関数
    abstract suspend fun createBoard(): Job
}