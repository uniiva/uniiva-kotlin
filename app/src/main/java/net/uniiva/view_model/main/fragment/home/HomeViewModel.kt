package net.uniiva.view_model.main.fragment.home

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.uniiva.databinding.FragmentHomeBinding
import net.uniiva.domain.main.fragment.home.HomeDomain

class HomeViewModel(
    private val binding: FragmentHomeBinding,
    activity: AppCompatActivity
) : HomeViewModelInterface, ViewModel() {

    private val homeDomain = HomeDomain(activity)

    class Factory(
        private val binding: FragmentHomeBinding,
        private val activity: AppCompatActivity
    ) : ViewModelProvider.Factory{
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            HomeViewModel(binding, activity) as T
    }

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