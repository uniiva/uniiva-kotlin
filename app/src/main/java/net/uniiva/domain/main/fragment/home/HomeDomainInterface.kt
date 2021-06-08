package net.uniiva.domain.main.fragment.home

import net.uniiva.model.main.fragment.home.Question
import org.koin.core.component.KoinComponent

interface HomeDomainInterface : KoinComponent{

    fun getQuestions(): MutableList<Question>
}