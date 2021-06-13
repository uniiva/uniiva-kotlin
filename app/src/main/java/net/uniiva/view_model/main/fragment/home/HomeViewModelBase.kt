package net.uniiva.view_model.main.fragment.home

import androidx.lifecycle.ViewModel
import net.uniiva.model.main.fragment.home.Board
import org.koin.core.component.KoinComponent

abstract class HomeViewModelBase : ViewModel(), KoinComponent {

    abstract var boards: MutableList<Board>

}