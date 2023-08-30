package dev.franco.vixapp.domain

import dev.franco.vixapi.data.local.VixRepo
import dev.franco.vixapp.ui.data.model.main.ContentStreamModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FetchFreemiumContentUseCase @Inject constructor(
    private val vixRepo: VixRepo,
    private val ioDispatcher: CoroutineDispatcher,
) : UseCase {
    override suspend fun invoke(vararg params: String?): Flow<ContentResult> {
        return vixRepo
            .fetchContent()
            .flowOn(ioDispatcher)
            .catch {
                ContentResult.Error(it.message.orEmpty())
            }
            .map { root ->
                val nodeId = root.data?.uiPage?.uiModules?.edges?.firstOrNull()?.cursor.orEmpty()
                val title = root
                    .data
                    ?.uiPage
                    ?.uiModules
                    ?.edges
                    ?.getOrNull(2)
                    ?.node
                    ?.title
                    .orEmpty()

                val content = root
                    .data
                    ?.uiPage
                    ?.uiModules
                    ?.edges
                    ?.getOrNull(2)
                    ?.node
                    ?.contents
                    ?.edges
                    ?.map { node ->
                        ContentStreamModel(
                            nodeId,
                            node?.cursor.orEmpty(),
                            node?.node?.image?.link.orEmpty(),
                        )
                    }
                    .orEmpty()

                ContentResult.Success(
                    title = title,
                    content = content,
                )
            }
    }
}

sealed class ContentResult() : Result() {
    class Success(
        val title: String,
        val content: List<ContentStreamModel>,
    ) : ContentResult()

    class Error(val message: String) : ContentResult()
}
