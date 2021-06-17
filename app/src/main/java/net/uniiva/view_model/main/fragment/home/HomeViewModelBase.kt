package net.uniiva.view_model.main.fragment.home

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import net.uniiva.entity.Board
import org.koin.core.component.KoinComponent

abstract class HomeViewModelBase : ViewModel(), KoinComponent {

    abstract var boards: MutableList<Board>

    //_boardsを監視対象にするための関数
    abstract fun setObserver(
        viewLifecycleOwner: LifecycleOwner,
        func: (MutableList<Board>) -> Unit
    )
}