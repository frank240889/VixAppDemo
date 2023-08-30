package dev.franco.vixapp.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import dev.franco.vixapp.R
import dev.franco.vixapp.ui.data.model.main.ContentStreamModel
import dev.franco.vixapp.ui.theme.VixAppTheme

@Composable
internal fun TopContent(
    content: List<ContentStreamModel>,
    onClickContent: (String, String) -> Unit,
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("top_content")
            .layoutId("top_content"),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        itemsIndexed(items = content) { _, item ->
            ElevatedCard(
                modifier = Modifier
                    .fillParentMaxWidth(0.7f)
                    .clickable {
                        onClickContent.invoke(item.nodeId, item.id)
                    },
            ) {
                val imageRequest = ImageRequest.Builder(LocalContext.current)
                    .data(item.previewUrl)
                    .crossfade(true)
                    .placeholder(R.drawable.vix_logo)
                    .memoryCachePolicy(CachePolicy.DISABLED)
                    .build()
                SubcomposeAsyncImage(
                    model = imageRequest,
                    contentDescription = null,
                    contentScale = ContentScale.Inside,
                    loading = {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .align(Alignment.Center),
                        )
                    },
                )
            }
        }
    }
}

@Preview
@Composable
private fun MainStreamContentPreview() {
    VixAppTheme {
        TopContent(
            content = emptyList(),
            onClickContent = { _, _ -> },
        )
    }
}
