package dev.franco.vixapp.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import dev.franco.vixapp.R
import dev.franco.vixapp.ui.data.model.main.ContentStreamModel
import dev.franco.vixapp.ui.theme.VixAppTheme

@Composable
internal fun StreamContent(
    title: CharSequence? = null,
    content: List<ContentStreamModel>,
    onClickContent: (String, String) -> Unit,
) {
    title?.let {
        Text(
            text = it.toString(),
            color = Color.White,
            fontSize = 16.sp,
        )
        Spacer(
            modifier = Modifier
                .height(16.dp),
        )
    }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("stream_content")
            .layoutId("stream_content"),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        itemsIndexed(items = content) { index, item ->
            ElevatedCard(
                modifier = Modifier
                    .fillParentMaxWidth(0.34f)
                    .fillParentMaxHeight(0.49f)
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
                AsyncImage(
                    model = imageRequest,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
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
