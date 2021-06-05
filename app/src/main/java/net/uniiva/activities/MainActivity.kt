package net.uniiva.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.uniiva.databinding.ActivityMainBinding
import net.uniiva.services.google_auth_service.GoogleAuthServiceInterface
import org.koin.android.ext.android.get
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity() {

    //ViewBinding
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    //Googleの認証系のサービス
    private lateinit var googleAuthService: GoogleAuthServiceInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        googleAuthService = get{ parametersOf(this)}

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
