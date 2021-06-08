package net.uniiva.view.main.fragment.home

import androidx.recyclerview.widget.RecyclerView
import net.uniiva.databinding.ItemHomeQuestionBinding

class HomeViewHolder(
    private val binding: ItemHomeQuestionBinding
    ) : RecyclerView.ViewHolder(binding.root) {

    fun setBind(title: String){
        binding.title = title
    }
}