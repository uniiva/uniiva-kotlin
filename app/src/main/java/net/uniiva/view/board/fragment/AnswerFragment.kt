package net.uniiva.view.board.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.coroutines.launch
import net.uniiva.databinding.FragmentBoardAnswerBinding
import net.uniiva.view_model.board.fragment.answer.AnswerViewModelBase
import org.koin.android.ext.android.inject

class AnswerFragment : Fragment(){

    private var _binding: FragmentBoardAnswerBinding? = null
    private val binding get() = _binding!!

    private val args: AnswerFragmentArgs by navArgs()

    private val answerViewModel: AnswerViewModelBase by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBoardAnswerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val boardId = args.boardId

        binding.answerViewModel = answerViewModel

        binding.apply {

            lifecycleOwner = viewLifecycleOwner

            //作成した回答を送信するボタン
            boardAnswerSubmit.setOnClickListener { boardAnswerSubmitOnClickListener(boardId) }
        }
    }

    //作成した回答を送信するボタンを押したときの処理
    private fun boardAnswerSubmitOnClickListener(boardId: String){
        lifecycleScope.launch {
            answerViewModel.createAnswer(boardId)
        }

        val action = AnswerFragmentDirections
            .actionNavigationBoardAnswerToNavigationBoardShow(boardId)
        findNavController().navigate(action)
    }
}