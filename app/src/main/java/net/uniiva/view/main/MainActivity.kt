package net.uniiva.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import net.uniiva.R
import net.uniiva.databinding.ActivityMainBinding
import net.uniiva.services.google_auth_service.GoogleAuthServiceInterface

class MainActivity : AppCompatActivity() {

    //ViewBinding
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    //Googleの認証系のサービス
    private lateinit var googleAuthService: GoogleAuthServiceInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        _binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        googleAuthService = get{ parametersOf(this)}

        val navController = supportFragmentManager.findFragmentById(R.id.main_fragment_container)
        val navView: BottomNavigationView = findViewById(R.id.main_bottom_navigation_view)

        navController?.let{
            navView.setupWithNavController(navController.findNavController())
        }

//        binding.apply {
//            signInButton.setOnClickListener {
//                googleAuthService.googleSignIn()
//                    userIdTextView.text = googleAuthService.auth.currentUser.toString()
//
//            }
//
//            signOutButton.setOnClickListener {
//                googleAuthService.googleSignOut()
//                userIdTextView.text = ""
//            }
//        }
    }
}
