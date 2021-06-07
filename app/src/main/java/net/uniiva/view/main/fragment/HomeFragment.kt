package net.uniiva.view.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import net.uniiva.databinding.FragmentHomeBinding
import net.uniiva.view_model.main.fragment.home.HomeViewModel
import net.uniiva.view_model.main.fragment.home.HomeViewModelInterface

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeViewModel: HomeViewModelInterface

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel = ViewModelProvider(
            this,
            HomeViewModel.Factory(requireActivity() as AppCompatActivity)
        ).get(HomeViewModel::class.java)

        binding.apply {

            signInButton.setOnClickListener{ homeViewModel.signInButtonOnClickListener() }
            signOutButton.setOnClickListener{ homeViewModel.signOutButtonOnClickListener() }

            userIdText = homeViewModel.userIdText
        }
    }
}