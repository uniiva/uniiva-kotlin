package net.uniiva.view.board.fragment.show

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.uniiva.databinding.ItemBoardShowAnswerBinding
import net.uniiva.databinding.ItemBoardShowQuestionBinding
import net.uniiva.entity.Answer
import net.uniiva.entity.Board
import net.uniiva.view.board.fragment.show.view_holder.ShowAnswerViewHolder
import net.uniiva.view.board.fragment.show.view_holder.ShowQuestionViewHolder

class ShowAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var board = Board("", "", "")
    var answers = mutableListOf<Answer>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when(viewType){
            VIEW_TYPE_QUESTION
            ->ShowQuestionViewHolder(ItemBoardShowQuestionBinding.inflate(inflater, parent, false))
            VIEW_TYPE_ANSWER
            ->ShowAnswerViewHolder(ItemBoardShowAnswerBinding.inflate(inflater, parent, false))
            else -> TODO()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(position){
            0 -> VIEW_TYPE_QUESTION
            else -> VIEW_TYPE_ANSWER
        }
    }

    override fun getItemCount(): Int {
        return answers.size + 1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ShowQuestionViewHolder -> holder.setBind(board)
            is ShowAnswerViewHolder -> holder.setBind(answers[position - 1])
        }
    }

    companion object{
        private const val VIEW_TYPE_QUESTION = 1
        private const val VIEW_TYPE_ANSWER = 2
    }
}