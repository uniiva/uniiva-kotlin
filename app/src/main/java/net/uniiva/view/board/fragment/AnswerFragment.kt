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

        val id = args.id

        binding.lifecycleOwner = viewLifecycleOwner

        binding.answerViewModel = answerViewModel

        binding.boardAnswerSubmit.setOnClickListener {

            lifecycleScope.launch {
                answerViewModel.createAnswer(id)
            }

            val action = AnswerFragmentDirections
                .actionNavigationBoardAnswerToNavigationBoardShow(id)
            findNavController().navigate(action)
        }
    }
}