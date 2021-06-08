package net.uniiva.domain.main.fragment.home

import net.uniiva.model.main.fragment.home.Question
import net.uniiva.repository.main.fragment.home.HomeRepositoryInterface
import org.koin.core.component.inject

class HomeDomain : HomeDomainInterface {

    private val homeRepository by inject<HomeRepositoryInterface>()

    override fun getQuestions(): MutableList<Question>{
        return homeRepository.getQuestion()
    }
}