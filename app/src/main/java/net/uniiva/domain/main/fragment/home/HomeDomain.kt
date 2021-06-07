package net.uniiva.domain.main.fragment.home

import androidx.appcompat.app.AppCompatActivity
import net.uniiva.services.google_auth_service.GoogleAuthServiceInterface
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class HomeDomain(private val activity: AppCompatActivity) : HomeDomainInterface, KoinComponent {

    //Googleの認証系のサービス
    private val googleAuthService: GoogleAuthServiceInterface by inject{(parametersOf(activity))}

    override fun signIn(): String{
        googleAuthService.googleSignIn()
        return googleAuthService.auth.currentUser.toString()
    }

    override fun signOut(){
        googleAuthService.googleSignOut()
    }

}