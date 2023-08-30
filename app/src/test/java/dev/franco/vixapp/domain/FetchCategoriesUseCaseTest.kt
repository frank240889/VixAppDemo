package dev.franco.vixapp.domain

import app.cash.turbine.test
import dev.franco.vixapi.data.local.VixRepo
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.assertThrows
import java.net.ConnectException

class FetchCategoriesUseCaseTest {
    private val testDispatcher = StandardTestDispatcher()
    private val vixRepo: VixRepo = mockk()
    private lateinit var fetchCategoriesUseCase: UseCase

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        fetchCategoriesUseCase = FetchCategoriesUseCase(
            vixRepo,
            testDispatcher,
        )
    }

    @Test
    fun whenFetchCategoriesUseCaseIsCalledThenSuccessResultIsReturned() = runTest {
        coEvery { vixRepo.fetchContent() } returns flow { emit(mockk(relaxed = true)) }

        fetchCategoriesUseCase.invoke().test {
            assert(awaitItem() is CategoriesResult.Success)
            awaitComplete()
        }
    }

    @Test
    fun whenFetchCategoriesUseCaseIsCalledThenErrorResultIsReturned() = runTest {
        coEvery { vixRepo.fetchContent() } throws ConnectException()

        assertThrows<Throwable> {
            vixRepo.fetchContent()
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}
