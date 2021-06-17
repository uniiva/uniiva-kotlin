package net.uniiva.view_model.main.fragment.home

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import net.uniiva.entity.Board
import org.koin.core.component.KoinComponent

abstract class HomeViewModelBase : ViewModel(), KoinComponent {

    //質問一覧を保持する変数
    abstract var boards: MutableList<Board>

    //LiveData変更時の処理を登録するための関数
    abstract fun setObserver(
        viewLifecycleOwner: LifecycleOwner,
        func: (MutableList<Board>) -> Unit
    )
}