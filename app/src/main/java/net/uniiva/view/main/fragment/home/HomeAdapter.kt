package net.uniiva.view.main.fragment.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.uniiva.databinding.ItemMainHomeQuestionBinding
import net.uniiva.entity.Board
import net.uniiva.view_model.main.fragment.home.HomeViewModelBase

class HomeAdapter(
    private val homeViewModel: HomeViewModelBase,
    private val viewSetOnClickListener: (View, String) -> Unit
    ) : RecyclerView.Adapter<HomeViewHolder>() {

    var boards: MutableList<Board> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return HomeViewHolder(ItemMainHomeQuestionBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return boards.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {

        val board = boards[position]

        //各Viewの初期設定
        holder.setBind(board)

        //問題をクリックしたら画面遷移する処理
        holder.binding.root.setOnClickListener{
            viewSetOnClickListener(it, board.id)
        }
    }
}