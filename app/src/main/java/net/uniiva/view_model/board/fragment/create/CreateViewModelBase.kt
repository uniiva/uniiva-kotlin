package net.uniiva.view_model.board.fragment.create

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job
import net.uniiva.entity.Board
import org.koin.core.component.KoinComponent

abstract class CreateViewModelBase : ViewModel(), KoinComponent {

    abstract var board: Board

    abstract suspend fun createBoard(): Job
}