package net.uniiva.repository.main.fragment.home

import net.uniiva.model.main.fragment.home.Question

interface HomeRepositoryInterface {

    fun getQuestion(): MutableList<Question>
}