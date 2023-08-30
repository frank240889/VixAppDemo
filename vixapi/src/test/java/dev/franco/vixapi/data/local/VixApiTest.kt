package dev.franco.vixapi.data.local

import app.cash.turbine.test
import dev.franco.vixapi.data.VixApi
import dev.franco.vixapi.domain.remote.ApiResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class VixApiTest {
    private val api: VixApi = mockk()
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun whenApiIsCalledASuccessResponseIsReturned() = runTest {
        coEvery { api.fetchContent() } returns flow { emit(mockk()) }
        api.fetchContent().test {
            assert(awaitItem() is ApiResponse)
            awaitComplete()
        }
    }

    @After
    fun teardown() {
        Dispatchers.resetMain()
    }
}
