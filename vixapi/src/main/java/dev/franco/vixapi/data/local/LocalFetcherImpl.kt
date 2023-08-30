package dev.franco.vixapi.data.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.franco.vixapi.R
import dev.franco.vixapi.domain.remote.ApiResponse
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.InputStreamReader
import javax.inject.Inject

class LocalFetcherImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : Fetcher {
    override suspend fun fetchContent(): ApiResponse {
        val data = context.resources.openRawResource(R.raw.inicio)
        val jsonString = deserialize(data)
        return createResponse(jsonString)
    }

    private fun deserialize(input: InputStream): String {
        return InputStreamReader(input).readText()
    }

    private fun createResponse(jsonString: String): ApiResponse {
        return Json.decodeFromString(jsonString)
    }
}
