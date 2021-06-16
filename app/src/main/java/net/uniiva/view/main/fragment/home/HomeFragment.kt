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

        //ViewModelの値を監視対象に登録
        homeViewModel.setObserver(viewLifecycleOwner){
            homeAdapter.boards = it
            homeAdapter.notifyDataSetChanged()
        }

        homeAdapter = HomeAdapter(homeViewModel, viewSetOnClickListener)

        homeRecyclerView = binding.homeRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = homeAdapter
        }

        //fabボタンを押したときに画面遷移する処理
        binding.homeCreateBoard.setOnClickListener {
            val intent = Intent(requireActivity(), BoardActivity::class.java)
            intent.putExtra("METHOD", "CREATE")
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        homeAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //問題をタップしたときに詳細に画面遷移する処理
    private val viewSetOnClickListener: (View, String) -> Unit = { _, id ->
        val intent = Intent(requireActivity(), BoardActivity::class.java)
        intent.putExtra("METHOD", "SHOW")
        intent.putExtra("ID", id)
        startActivity(intent)
    }
}