package net.uniiva.view_model.board.fragment.create

import androidx.lifecycle.ViewModel
import net.uniiva.model.share.Board
import org.koin.core.component.KoinComponent

abstract class CreateViewModelBase : ViewModel(), KoinComponent {

    abstract var board: Board

    abstract fun createBoard()
}