package net.uniiva.view.main.fragment.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.uniiva.databinding.FragmentMainHomeBinding
import net.uniiva.view.board.BoardActivity
import net.uniiva.view_model.main.fragment.home.HomeViewModelBase
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private var _binding: FragmentMainHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModelBase by inject()

    private lateinit var homeAdapter: HomeAdapter
    private lateinit var homeRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.setData()

        homeAdapter = HomeAdapter(homeViewModel)

        homeRecyclerView = binding.homeRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = homeAdapter
        }

        binding.homeCreateBoard.setOnClickListener {
            val intent = Intent(requireActivity(), BoardActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}