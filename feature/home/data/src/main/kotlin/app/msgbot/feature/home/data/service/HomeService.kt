package app.msgbot.feature.home.data.service

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url

class HomeService(
    private val client: HttpClient
) {
    suspend fun getHome(author: String, repo: String) {
        client.get {
            url("https://api.github.com/repos/$author/$repo/releases/latest")
        }.
    }
}