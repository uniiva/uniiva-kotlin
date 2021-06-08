package net.uniiva.view.main.fragment.home

import androidx.recyclerview.widget.RecyclerView
import net.uniiva.databinding.ItemHomeQuestionBinding
import net.uniiva.model.main.fragment.home.Question

class HomeViewHolder(
    private val binding: ItemHomeQuestionBinding
    ) : RecyclerView.ViewHolder(binding.root) {

    fun setBind(question: Question){
        binding.question = question
    }
}