package net.uniiva.view.main.fragment.home

import androidx.recyclerview.widget.RecyclerView
import net.uniiva.databinding.ItemMainHomeQuestionBinding
import net.uniiva.entity.Board

class HomeViewHolder(
    val binding: ItemMainHomeQuestionBinding
    ) : RecyclerView.ViewHolder(binding.root) {

    fun setBind(board: Board){
        binding.board = board
    }
}