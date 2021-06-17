package net.uniiva.view.board.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import net.uniiva.databinding.FragmentBoardAnswerBinding

class AnswerFragment : Fragment(){

    private var _binding: FragmentBoardAnswerBinding? = null
    private val binding get() = _binding!!

    private val args: AnswerFragmentArgs by navArgs()

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

        binding.boardAnswerSubmit.setOnClickListener {
            val action = AnswerFragmentDirections
                .actionNavigationBoardAnswerToNavigationBoardShow(id)
            findNavController().navigate(action)
        }
    }
}