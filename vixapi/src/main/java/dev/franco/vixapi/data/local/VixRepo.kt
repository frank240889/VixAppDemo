package dev.franco.vixapi.data.local

import dev.franco.vixapi.domain.remote.ApiResponse
import kotlinx.coroutines.flow.Flow

interface VixRepo {
    suspend fun fetchContent(): Flow<ApiResponse>
}
