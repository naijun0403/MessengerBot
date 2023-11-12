package app.msgbot.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import app.msgbot.network.service.GithubApiService
import com.orhanobut.logger.Logger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class HomeViewModel : ViewModel() {

    val githubApiService: GithubApiService by inject(GithubApiService::class.java)

    sealed class VersionLoadState {
        data object Loading : VersionLoadState()
        data class Success(val isLatestVersion: Boolean) : VersionLoadState()
        data class Error(val message: String) : VersionLoadState()
    }

    private var _state = MutableStateFlow<VersionLoadState>(VersionLoadState.Loading)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                Logger.d("Loading...")
                val data = githubApiService.getLatestRelease()

                Logger.d(data)

                _state.value = VersionLoadState.Success(true) // 아직 릴리즈를 안해서 true로 설정
            } catch (e: Exception) {
                Logger.e(e, "Error while loading version")
                _state.value = VersionLoadState.Error(e.message ?: "Unknown error")
            }
        }
    }

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