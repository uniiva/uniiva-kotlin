package net.uniiva.services.google_auth_service

import com.google.firebase.auth.FirebaseAuth

interface GoogleAuthServiceInterface{

    //ログイン情報
    val auth: FirebaseAuth

    //サインイン
    fun googleSignIn()

    //サインアウト
    fun googleSignOut()
}