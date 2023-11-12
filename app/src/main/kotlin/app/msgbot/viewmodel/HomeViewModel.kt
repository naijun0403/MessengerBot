package app.msgbot.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.msgbot.network.service.GithubApiService
import org.koin.java.KoinJavaComponent.inject

class HomeViewModel : ViewModel() {

    val githubApiService: GithubApiService by inject(GithubApiService::class.java)

}

class HomeViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}