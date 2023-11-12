package app.msgbot.viewmodel

import androidx.lifecycle.ViewModel
import app.msgbot.network.service.GithubApiService
import org.koin.java.KoinJavaComponent.inject

class HomeViewModel : ViewModel() {

    val githubApiService: GithubApiService by inject(GithubApiService::class.java)

}