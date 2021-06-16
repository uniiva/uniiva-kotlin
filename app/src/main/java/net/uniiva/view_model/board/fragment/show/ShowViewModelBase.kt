package net.uniiva.view_model.board.fragment.show

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job
import net.uniiva.model.share.Board
import org.koin.core.component.KoinComponent

abstract class ShowViewModelBase : ViewModel(), KoinComponent {

    abstract var board: Board?

    abstract suspend fun setBoard(id: String): Job

    abstract fun setObserver(
        viewLifecycleOwner: LifecycleOwner,
        func: (Board) -> Unit
    )
}