package net.uniiva.view_model.board.fragment.show

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import net.uniiva.model.share.Board
import org.koin.core.component.KoinComponent

abstract class ShowViewModelBase : ViewModel(), KoinComponent {

    abstract var board: Board?

    abstract fun setBoard(id: String)

    abstract fun setObserver(
        viewLifecycleOwner: LifecycleOwner,
        func: (Board) -> Unit
    )
}