package net.uniiva.repository.main.fragment.home

import net.uniiva.model.main.fragment.home.Question

class HomeRepository : HomeRepositoryInterface{
    override fun getQuestion(): MutableList<Question> {
        return mutableListOf(
            Question("TITLE1", "CONTENTS1"),
            Question("TITLE2", "CONTENTS2"),
            Question("TITLE3", "CONTENTS3"),
            Question("TITLE4", "CONTENTS4")
        )
    }

}