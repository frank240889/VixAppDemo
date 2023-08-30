package dev.franco.vixapi.data

import dev.franco.vixapi.domain.remote.ApiResponse
import kotlinx.coroutines.flow.Flow

interface VixApi {
    suspend fun fetchContent(): Flow<ApiResponse>
}
