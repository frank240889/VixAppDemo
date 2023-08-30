package dev.franco.vixapp.ui.main

import app.cash.turbine.test
import dev.franco.vixapp.domain.CategoriesResult
import dev.franco.vixapp.domain.FetchCategoriesUseCase
import dev.franco.vixapp.domain.FetchFreemiumContentUseCase
import dev.franco.vixapp.domain.FetchMainContentUseCase
import dev.franco.vixapp.domain.FetchPremiumContentUseCase
import dev.franco.vixapp.domain.UseCase
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

class MainViewModelTest {
    private val fetchCategoriesUseCase: UseCase = mockk<FetchCategoriesUseCase>()
    private val fetchMainContentUseCase: UseCase = mockk<FetchMainContentUseCase>()
    private val fetchFreemiumContentUseCase: UseCase = mockk<FetchFreemiumContentUseCase>()
    private val fetchPremiumContentUseCase: UseCase = mockk<FetchPremiumContentUseCase>()
    private lateinit var mainViewModel: MainViewModel
    private val mainTestDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(mainTestDispatcher)
        mainViewModel = MainViewModel(
            fetchCategoriesUseCase,
            fetchMainContentUseCase,
            fetchFreemiumContentUseCase,
            fetchPremiumContentUseCase,
        )
    }

    @Test
    fun whenCategoriesAreFetchedThenSuccessResponseIsReturned() = runTest {
        coEvery { fetchCategoriesUseCase() } returns flow {
            emit(CategoriesResult.Success(emptyList()))
        }

        fetchCategoriesUseCase.invoke().test {
            assert(awaitItem() is CategoriesResult.Success)
            awaitComplete()
        }
    }

    @Test
    fun whenCategoriesAreFetchedThenErrorResponseIsReturned() = runTest {
        coEvery { fetchCategoriesUseCase() } returns flow {
            emit(CategoriesResult.Error("Error"))
        }

        fetchCategoriesUseCase.invoke().test {
            assert(awaitItem() is CategoriesResult.Error)
            awaitComplete()
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}
