package net.uniiva.view.main.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.uniiva.databinding.ItemHomeQuestionBinding
import net.uniiva.view_model.main.fragment.home.HomeViewModelBase

class HomeAdapter(
    private val homeViewModel: HomeViewModelBase
    ) : RecyclerView.Adapter<HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return HomeViewHolder(ItemHomeQuestionBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return homeViewModel.questions.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.setBind(homeViewModel.questions[position])
    }
}