package net.uniiva.view.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import net.uniiva.databinding.FragmentCircleBinding

class CircleFragment : Fragment() {

    private var _binding: FragmentCircleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCircleBinding.inflate(inflater, container, false)
        return binding.root
    }
}