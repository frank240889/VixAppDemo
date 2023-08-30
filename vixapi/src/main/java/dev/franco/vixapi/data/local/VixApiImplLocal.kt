package dev.franco.vixapi.data.local

import dev.franco.vixapi.data.VixApi
import dev.franco.vixapi.domain.remote.ApiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class VixApiImplLocal @Inject constructor(
    private val fetcher: Fetcher,
) : VixApi {
    override suspend fun fetchContent(): Flow<ApiResponse> {
        return flowOf(fetcher.fetchContent())
    }
}
