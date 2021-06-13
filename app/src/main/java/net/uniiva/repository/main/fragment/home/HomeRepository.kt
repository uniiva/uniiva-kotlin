package net.uniiva.repository.main.fragment.home

import net.uniiva.model.main.fragment.home.Question
import java.util.*

class HomeRepository : HomeRepositoryInterface{
    override fun getQuestion(): MutableList<Question> {
        return mutableListOf(
            Question(UUID.randomUUID().toString(), "TITLE1", "CONTENTS1"),
            Question(UUID.randomUUID().toString(), "TITLE2", "CONTENTS2"),
            Question(UUID.randomUUID().toString(), "TITLE3", "CONTENTS3"),
            Question(UUID.randomUUID().toString(), "TITLE4", "CONTENTS4")
        )
    }

}