package net.uniiva.view.main.fragment.home

import androidx.recyclerview.widget.RecyclerView
import net.uniiva.databinding.ItemMainHomeQuestionBinding
import net.uniiva.model.main.fragment.home.Question

class HomeViewHolder(
    val binding: ItemMainHomeQuestionBinding
    ) : RecyclerView.ViewHolder(binding.root) {

    fun setBind(question: Question){
        binding.question = question
    }
}