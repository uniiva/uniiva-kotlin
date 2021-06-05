package net.uniiva.presenter.main.fragment.home

import androidx.appcompat.app.AppCompatActivity
import net.uniiva.databinding.FragmentHomeBinding
import net.uniiva.domain.main.fragment.home.HomeDomain

class HomePresenter(
    private val binding: FragmentHomeBinding,
    activity: AppCompatActivity
) : HomePresenterInterface {

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