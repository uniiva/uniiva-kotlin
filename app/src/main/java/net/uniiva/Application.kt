package net.uniiva

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import net.uniiva.domain.main.fragment.home.HomeDomain
import net.uniiva.domain.main.fragment.home.HomeDomainInterface
import net.uniiva.repository.main.fragment.home.HomeRepository
import net.uniiva.repository.main.fragment.home.HomeRepositoryInterface
import net.uniiva.services.google_auth_service.GoogleAuthService
import net.uniiva.services.google_auth_service.GoogleAuthServiceInterface
import net.uniiva.services.google_auth_service.GoogleAuthServiceMock
import net.uniiva.view_model.board.fragment.create.CreateViewModel
import net.uniiva.view_model.board.fragment.create.CreateViewModelBase
import net.uniiva.view_model.main.fragment.home.HomeViewModel
import net.uniiva.view_model.main.fragment.home.HomeViewModelBase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : Application() {

    private val module = module {
        factory<GoogleAuthServiceInterface>{ (activity: AppCompatActivity) -> GoogleAuthService(activity) }
        factory<HomeDomainInterface> { HomeDomain() }
        factory<HomeRepositoryInterface> { HomeRepository() }
    }

    private val testModule = module{
        factory<GoogleAuthServiceInterface>{ (activity: AppCompatActivity) -> GoogleAuthServiceMock(activity) }
        factory<HomeDomainInterface> { HomeDomain() }
        single<HomeRepositoryInterface> { HomeRepository() }
        viewModel<HomeViewModelBase> { HomeViewModel() }
        viewModel<CreateViewModelBase> { CreateViewModel() }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)

            modules(testModule)
        }
    }
}