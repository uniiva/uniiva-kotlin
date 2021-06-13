package net.uniiva.view_model.board.fragment.create

import androidx.lifecycle.ViewModel
import net.uniiva.model.share.Board

abstract class CreateViewModelBase : ViewModel() {

    abstract var board: Board
}