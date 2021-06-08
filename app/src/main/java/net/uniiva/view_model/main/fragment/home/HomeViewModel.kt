package net.uniiva.view_model.main.fragment.home

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.uniiva.domain.main.fragment.home.HomeDomain
import net.uniiva.model.fragment.home.Question

class HomeViewModel(
    activity: AppCompatActivity
) : HomeViewModelInterface, ViewModel() {

    private val homeDomain = HomeDomain(activity)

    private val _questions: MutableLiveData<MutableList<Question>> = MutableLiveData()
    override var questions: MutableList<Question>
        get() = _questions.value ?: mutableListOf()
        set(value) { _questions.postValue(value) }

    class Factory(
        private val activity: AppCompatActivity
    ) : ViewModelProvider.Factory{
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            HomeViewModel(activity) as T
    }
}