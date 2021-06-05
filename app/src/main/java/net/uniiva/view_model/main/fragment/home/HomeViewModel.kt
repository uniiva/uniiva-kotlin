package net.uniiva.view_model.main.fragment.home

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import net.uniiva.databinding.FragmentHomeBinding
import net.uniiva.domain.main.fragment.home.HomeDomain

class HomeViewModel(
    private val binding: FragmentHomeBinding,
    activity: AppCompatActivity
) : HomeViewModelInterface, ViewModel() {

    private val homeDomain = HomeDomain(activity)

    override fun setView(){
        binding.apply {
            signInButton.setOnClickListener {
                userIdTextView.text = homeDomain.signIn()
            }

            signOutButton.setOnClickListener {
                homeDomain.signOut()
                userIdTextView.text = ""
            }
        }
    }
}