package dev.franco.vixapp.domain

import dev.franco.vixapi.data.local.VixRepo
import dev.franco.vixapp.R
import dev.franco.vixapp.helpers.ResourceManager
import dev.franco.vixapp.ui.data.model.detail.ContentDetailModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FetchDetailContentUseCase @Inject constructor(
    private val vixRepo: VixRepo,
    private val resourceManager: ResourceManager,
    private val ioDispatcher: CoroutineDispatcher,
) : UseCase {
    override suspend fun invoke(vararg params: String?): Flow<DetailContentResult> {
        val id = params.firstOrNull().orEmpty()
        return vixRepo
            .fetchContent()
            .catch {
                DetailContentResult.Error(it.message.orEmpty())
            }
            .map { root ->
                val node = root
                    .data
                    ?.uiPage
                    ?.uiModules
                    ?.edges
                    ?.find { n ->
                        n?.node?.contents?.edges?.find { it?.node?.video?.id == id } != null
                    }
                    ?.node
                    ?.contents
                    ?.edges
                    ?.find {
                        it?.cursor == id
                    }

                if (node == null) {
                    DetailContentResult.Error(resourceManager.getString(R.string.item_not_found))
                } else {
                    val title = node.node?.video?.title.orEmpty()
                    val description = node.node?.video?.description.orEmpty()
                    val genres = node.node?.video?.genres?.map { it.orEmpty() }
                    val year = node.node?.video?.copyrightYear?.toString() ?: ""
                    val ratings =
                        node.node?.video?.ratings?.map { it?.ratingValue.orEmpty() }.orEmpty()
                    val director = node
                        .node
                        ?.video
                        ?.contributors?.joinToString("") {
                            if (!it?.roles?.find { it2 -> it2 == "DIRECTOR" }.isNullOrBlank()) {
                                it?.name.orEmpty()
                            } else {
                                ""
                            }
                        }
                        .orEmpty()

                    val casting = node
                        .node
                        ?.video
                        ?.contributors
                        ?.map {
                            it?.name.orEmpty()
                        }
                        .orEmpty()

                    val cover = node
                        .node
                        ?.video
                        ?.imageAssets
                        ?.find {
                            it?.imageRole == "VERTICAL_POSTER"
                        }?.link ?: node
                        .node
                        ?.image
                        ?.link
                        .orEmpty()

                    val contentDetail = ContentDetailModel(
                        title = title,
                        description = description,
                        genre = genres,
                        year = year,
                        ratings = ratings,
                        chips = listOf("Otros recomiendan", "Más", "Detalles"),
                        director = director,
                        casting = casting,
                        cover = cover,
                    )
                    DetailContentResult.Success(contentDetail)
                }
            }
            .flowOn(ioDispatcher)
    }
}

sealed class DetailContentResult() : Result() {
    class Success(val contentDetail: ContentDetailModel) : DetailContentResult()
    class Error(val message: String) : DetailContentResult()
}
