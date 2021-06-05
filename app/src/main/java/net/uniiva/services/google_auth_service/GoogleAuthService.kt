package net.uniiva.services.google_auth_service

import android.app.Activity
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import net.uniiva.R

class GoogleAuthService(private val activity: AppCompatActivity) : GoogleAuthServiceInterface{

    private val getActivityResultCallback = { result: ActivityResult ->
        if(result.resultCode == Activity.RESULT_OK){
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Log.d("Firebase Auth: ", "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w("Firebase Auth: ", "Google sign in failed", e)
            }
        }
    }
    override val auth: FirebaseAuth

    private val googleSignInClient: GoogleSignInClient
    private val getActivityResult = activity.registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        getActivityResultCallback
    )

    init {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(activity.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(activity, gso)

        auth = Firebase.auth
    }

    //サインイン
    override fun googleSignIn(){

        val signInIntent = googleSignInClient.signInIntent

        getActivityResult.launch(signInIntent)
    }

    //サインアウト
    override fun googleSignOut() {
        auth.signOut()
        googleSignInClient.signOut()
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Firebase Auth: ", "signInWithCredential:success")
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Firebase Auth: ", "signInWithCredential:failure", task.exception)
                }
            }
    }
}