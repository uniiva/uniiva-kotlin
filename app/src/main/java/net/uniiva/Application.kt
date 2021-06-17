package net.uniiva

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import net.uniiva.domain.board.fragment.answer.AnswerDomain
import net.uniiva.domain.board.fragment.answer.AnswerDomainInterface
import net.uniiva.domain.board.fragment.create.CreateDomain
import net.uniiva.domain.board.fragment.create.CreateDomainInterface
import net.uniiva.domain.board.fragment.show.ShowDomain
import net.uniiva.domain.board.fragment.show.ShowDomainInterface
import net.uniiva.view_model.board.fragment.show.ShowViewModel
import net.uniiva.view_model.board.fragment.show.ShowViewModelBase
import net.uniiva.domain.main.fragment.home.HomeDomain
import net.uniiva.domain.main.fragment.home.HomeDomainInterface
import net.uniiva.repository.answer.AnswerRepository
import net.uniiva.repository.answer.AnswerRepositoryInterface
import net.uniiva.repository.board.BoardRepository
import net.uniiva.repository.board.BoardRepositoryInterface
import net.uniiva.services.google_auth_service.GoogleAuthService
import net.uniiva.services.google_auth_service.GoogleAuthServiceInterface
import net.uniiva.services.google_auth_service.GoogleAuthServiceMock
import net.uniiva.view_model.board.fragment.answer.AnswerViewModel
import net.uniiva.view_model.board.fragment.answer.AnswerViewModelBase
import net.uniiva.view_model.board.fragment.create.CreateViewModel
import net.uniiva.view_model.board.fragment.create.CreateViewModelBase
import net.uniiva.view_model.main.fragment.home.HomeViewModel
import net.uniiva.view_model.main.fragment.home.HomeViewModelBase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : Application() {

    //Koinの設定
    private val module = module {
        factory<GoogleAuthServiceInterface>{ (activity: AppCompatActivity) -> GoogleAuthService(activity) }
        factory<HomeDomainInterface> { HomeDomain() }
        factory<BoardRepositoryInterface> { BoardRepository() }
    }

    private val testModule = module{
        factory<GoogleAuthServiceInterface>{ (activity: AppCompatActivity) -> GoogleAuthServiceMock(activity) }

        factory<HomeDomainInterface> { HomeDomain() }
        factory<CreateDomainInterface> { CreateDomain() }
        factory<ShowDomainInterface> { ShowDomain() }
        factory<AnswerDomainInterface> { AnswerDomain() }

        single<BoardRepositoryInterface> { BoardRepository() }
        single<AnswerRepositoryInterface> { AnswerRepository() }

        viewModel<HomeViewModelBase> { HomeViewModel() }

        viewModel<CreateViewModelBase> { CreateViewModel() }
        viewModel<ShowViewModelBase> { ShowViewModel() }
        viewModel<AnswerViewModelBase> { AnswerViewModel() }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)

            modules(testModule)
        }
    }
}