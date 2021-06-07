package net.uniiva.view_model.main.fragment.home

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.uniiva.domain.main.fragment.home.HomeDomain

class HomeViewModel(
    activity: AppCompatActivity
) : HomeViewModelInterface, ViewModel() {

    private val homeDomain = HomeDomain(activity)

    private val _userIdText: MutableLiveData<String> = MutableLiveData("")
    override var userIdText: String
        get() = _userIdText.value ?: ""
        set(value){
            _userIdText.postValue(value)
        }

    override fun signInButtonOnClickListener(){
        userIdText = homeDomain.signIn()
    }

    override fun signOutButtonOnClickListener(){
        homeDomain.signOut()
        userIdText = ""
    }

    class Factory(
        private val activity: AppCompatActivity
    ) : ViewModelProvider.Factory{
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            HomeViewModel(activity) as T
    }
}