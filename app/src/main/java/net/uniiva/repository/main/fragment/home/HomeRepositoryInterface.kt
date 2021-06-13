package net.uniiva.repository.main.fragment.home

import net.uniiva.model.main.fragment.home.Board

interface HomeRepositoryInterface {

    //現在出ている問題を取得する関数
    fun getBoards(): MutableList<Board>
}