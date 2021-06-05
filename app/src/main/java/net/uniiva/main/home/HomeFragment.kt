package net.uniiva.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import net.uniiva.databinding.FragmentHomeBinding
import net.uniiva.services.google_auth_service.GoogleAuthServiceInterface
import org.koin.android.ext.android.get
import org.koin.core.parameter.parametersOf

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    //Googleの認証系のサービス
    private lateinit var googleAuthService: GoogleAuthServiceInterface

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

        googleAuthService = get{ parametersOf(requireActivity()) }


        binding.apply {
            signInButton.setOnClickListener {
                googleAuthService.googleSignIn()
                userIdTextView.text = googleAuthService.auth.currentUser.toString()

            }

            signOutButton.setOnClickListener {
                googleAuthService.googleSignOut()
                userIdTextView.text = ""
            }
        }
    }
}