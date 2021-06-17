package net.uniiva.view.board.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.launch
import net.uniiva.databinding.FragmentBoardCreateBinding
import net.uniiva.view_model.board.fragment.create.CreateViewModelBase
import org.koin.android.ext.android.inject

class CreateFragment : Fragment(){

    private var _binding: FragmentBoardCreateBinding? = null
    private val binding get() = _binding!!

    private val createViewModel: CreateViewModelBase by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBoardCreateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner

        binding.createViewModel = createViewModel

        binding.boardCreateSubmit.setOnClickListener {
            lifecycleScope.launch {
                createViewModel.createBoard()
                val action = CreateFragmentDirections
                    .actionNavigationBoardCreateToNavigationBoardShow(createViewModel.board.id)
                findNavController().navigate(action)
            }
        }
    }
}