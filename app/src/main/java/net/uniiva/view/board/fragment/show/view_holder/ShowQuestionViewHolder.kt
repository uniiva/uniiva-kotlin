package net.uniiva.view.board.fragment.show.view_holder

import androidx.recyclerview.widget.RecyclerView
import net.uniiva.databinding.ItemBoardShowQuestionBinding
import net.uniiva.entity.Board

class ShowQuestionViewHolder(
    private val binding: ItemBoardShowQuestionBinding
    ) : RecyclerView.ViewHolder(binding.root) {

    fun setBind(board: Board){
        binding.board = board
    }
}