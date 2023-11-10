package app.msgbot.network.service

import app.msgbot.model.GithubReleaseModel
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path

interface GithubApiService {

    companion object {
        const val baseUrl = "https://api.github.com/"
    }

    @GET("repos/{author}/{repo}/releases/latest")
    suspend fun getLatestRelease(
        @Path("author") author: String = "naijun0403",
        @Path("repo") repo: String = "MessengerBot"
    ): GithubReleaseModel

}