package dev.franco.vixapp.domain

import dev.franco.vixapi.data.local.VixRepo
import dev.franco.vixapp.ui.data.model.main.ContentStreamModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FetchMainContentUseCase @Inject constructor(
    private val vixRepo: VixRepo,
    private val ioDispatcher: CoroutineDispatcher,
) : UseCase {
    override suspend fun invoke(vararg params: String?): Flow<MainContentResult> {
        return vixRepo
            .fetchContent()
            .flowOn(ioDispatcher)
            .catch {
                MainContentResult.Error(it.message.orEmpty())
            }
            .map { root ->
                val nodeId = root.data?.uiPage?.uiModules?.edges?.firstOrNull()?.cursor.orEmpty()
                MainContentResult.Success(
                    root
                        .data
                        ?.uiPage
                        ?.uiModules
                        ?.edges
                        ?.firstOrNull()
                        ?.node
                        ?.contents
                        ?.edges
                        ?.map { node ->
                            ContentStreamModel(
                                nodeId,
                                node?.cursor.orEmpty(),
                                node?.node?.mobileFillImage?.link,
                            )
                        }
                        .orEmpty(),
                )
            }
    }
}

sealed class MainContentResult() : Result() {
    class Success(val mainContent: List<ContentStreamModel>) : MainContentResult()
    class Error(val message: String) : MainContentResult()
}
