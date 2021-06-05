package net.uniiva.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.uniiva.databinding.ActivityMainBinding
import net.uniiva.services.GoogleAuthService

class MainActivity : AppCompatActivity() {

    //ViewBinding
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    //Googleの認証系のサービス
    private lateinit var googleAuthService: GoogleAuthService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        googleAuthService = GoogleAuthService(this)

        binding.apply {
            signInButton.setOnClickListener {
                googleAuthService.googleSignIn()
                    userIdTextView.text = googleAuthService.auth.currentUser.toString()

            }

            signOutButton.setOnClickListener {
                googleAuthService.googleSignOut()
                userIdTextView.text = ""
            }
        }
    }
}
