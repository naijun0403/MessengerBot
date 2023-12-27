package app.msgbot.feature.github.data.service

import org.kohsuke.github.GHRelease
import org.kohsuke.github.GitHub

class GithubApiService {

    private val github: GitHub = GitHub.connect()

    fun getLatestRelease(): GHRelease {
        // 721151362 -> naijun0403/messengerbot-release
        return github.getRepositoryById(721151362).latestRelease
    }

}