package net.uniiva.view.board

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import net.uniiva.R
import net.uniiva.view.board.fragment.show.ShowFragmentArgs

class BoardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)

        //navControllerの取得
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.board_fragment_container) as NavHostFragment

        val navController = navHostFragment.navController


        //遷移場所の設定
        val destination = when(intent.getStringExtra("METHOD")){
            "SHOW" -> R.id.navigation_board_show
            "CREATE" -> R.id.navigation_board_create

            else -> R.id.navigation_board_create
        }

        val navGraph = navController.navInflater.inflate(R.navigation.board_navigation).apply {
            startDestination = destination
        }


        //与える値の設定
        when(intent.getStringExtra("METHOD")){
            "SHOW" -> {
                intent.getStringExtra("ID")?.let{
                    navController.setGraph(navGraph, ShowFragmentArgs(it).toBundle())
                }
            }
        }

    }
}