package dev.franco.vixapi.data.local

import dev.franco.vixapi.data.VixApi
import dev.franco.vixapi.domain.remote.ApiResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VixRepoImpl @Inject constructor(
    private val vixApi: VixApi,
) : VixRepo {
    override suspend fun fetchContent(): Flow<ApiResponse> {
        return vixApi.fetchContent()
    }
}
