package dev.franco.vixapi.data.local

import dev.franco.vixapi.domain.remote.ApiResponse

interface Fetcher {
    suspend fun fetchContent(): ApiResponse
}
