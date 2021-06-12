package net.uniiva.view_model.main.fragment.home

import androidx.lifecycle.MutableLiveData
import net.uniiva.domain.main.fragment.home.HomeDomainInterface
import net.uniiva.model.main.fragment.home.Question
import org.koin.core.component.inject

class HomeViewModel : HomeViewModelBase(){

    private val homeDomain by inject<HomeDomainInterface>()

    private val _questions: MutableLiveData<MutableList<Question>> = MutableLiveData()
    override var questions: MutableList<Question>
        get() = _questions.value ?: mutableListOf()
        set(value) { _questions.postValue(value) }

    override fun setData(){
        questions = homeDomain.getQuestions()
    }
}