package net.uniiva.services.google_auth_service

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class GoogleAuthServiceMock(private val activity: AppCompatActivity) : GoogleAuthServiceInterface {

    override val auth: FirebaseAuth = Firebase.auth

    override fun googleSignIn() {
        Toast.makeText(activity, "（テスト）サインインしました", Toast.LENGTH_LONG).show()
    }

    override fun googleSignOut() {
        Toast.makeText(activity, "（テスト）サインアウトしました", Toast.LENGTH_LONG).show()
    }
}