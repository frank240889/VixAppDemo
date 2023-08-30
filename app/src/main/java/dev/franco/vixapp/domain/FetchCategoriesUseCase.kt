package dev.franco.vixapp.domain

import dev.franco.vixapi.data.local.VixRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FetchCategoriesUseCase @Inject constructor(
    private val vixRepo: VixRepo,
    private val ioDispatcher: CoroutineDispatcher,
) : UseCase {
    override suspend fun invoke(vararg params: String?): Flow<CategoriesResult> {
        return vixRepo
            .fetchContent()
            .flowOn(ioDispatcher)
            .catch {
                CategoriesResult.Error(it.message.orEmpty())
            }
            .map {
                CategoriesResult.Success(listOf(it.data?.uiPage?.pageName.orEmpty()))
            }
    }
}

sealed class CategoriesResult() : Result() {
    class Success(val categories: List<String>) : CategoriesResult()
    class Error(val message: String) : CategoriesResult()
}
