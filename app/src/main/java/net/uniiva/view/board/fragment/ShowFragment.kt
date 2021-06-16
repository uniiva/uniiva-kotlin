package net.uniiva.view.board.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import kotlinx.coroutines.launch
import net.uniiva.databinding.FragmentBoardShowBinding
import net.uniiva.model.share.Board
import net.uniiva.view_model.board.fragment.show.ShowViewModelBase
import org.koin.android.ext.android.inject

class ShowFragment : Fragment() {

    private var _binding: FragmentBoardShowBinding? = null
    private val binding get() = _binding!!

    private val args: ShowFragmentArgs by navArgs()

    private val showViewModel: ShowViewModelBase by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBoardShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = args.id

        showViewModel.apply {
            lifecycleScope.launch {
                setBoard(id)
                setObserver(viewLifecycleOwner, setObserver)
            }
        }


        //戻るボタンを押したときにactivityを終わらせる処理
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(
                viewLifecycleOwner,
                object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {
                        requireActivity().finish()
                    }
                }
            )

    }

    private val setObserver: (Board) -> Unit = {
        binding.apply {
            boardShowBoardTitle.text = it.title
            boardShowBoardContents.text = it.contents
        }
    }
}