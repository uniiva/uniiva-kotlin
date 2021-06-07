package net.uniiva

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import net.uniiva.domain.main.fragment.home.HomeDomainInterface
import net.uniiva.services.google_auth_service.GoogleAuthService
import net.uniiva.services.google_auth_service.GoogleAuthServiceInterface
import net.uniiva.services.google_auth_service.GoogleAuthServiceMock
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : Application() {

    private val module = module {
        factory<GoogleAuthServiceInterface>{ (activity: AppCompatActivity) -> GoogleAuthService(activity) }
    }

    private val testModule = module{
        factory<GoogleAuthServiceInterface>{ (activity: AppCompatActivity) -> GoogleAuthServiceMock(activity) }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)

            modules(testModule)
        }
    }
}