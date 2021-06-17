package net.uniiva.view.board.fragment.show.view_holder

import androidx.recyclerview.widget.RecyclerView
import net.uniiva.databinding.ItemBoardShowAnswerBinding
import net.uniiva.entity.Answer

class ShowAnswerViewHolder(private val binding: ItemBoardShowAnswerBinding) : RecyclerView.ViewHolder(binding.root) {

    fun setBind(answer: Answer){
        println(answer)
        binding.answer = answer
    }
}