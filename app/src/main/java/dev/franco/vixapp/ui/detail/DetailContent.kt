package dev.franco.vixapp.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import dev.franco.vixapp.R
import dev.franco.vixapp.ui.data.model.detail.ContentDetailModel
import dev.franco.vixapp.ui.theme.ButtonColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun DetailContent(
    contentDetail: ContentDetailModel,
) {
    val imageRequest = ImageRequest.Builder(LocalContext.current)
        .data(contentDetail.cover)
        .crossfade(true)
        .placeholder(R.drawable.vix_logo)
        .memoryCachePolicy(CachePolicy.DISABLED)
        .build()

    AsyncImage(
        model = imageRequest,
        contentDescription = "",
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.Crop,
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    0.2f to Color.Transparent,
                    1f to Color.Black,
                    startY = 0.0f,
                ),
            )
            .verticalScroll(rememberScrollState())
            .testTag("detail_content")
            .layoutId("detail_content"),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
        ) {
            Spacer(
                modifier = Modifier
                    .height(256.dp),
            )
            Text(
                text = contentDetail.title.toString(),
                fontSize = 38.sp,
                color = Color.White,
                fontWeight = FontWeight.Light,
                lineHeight = 38.sp,
                modifier = Modifier
                    .fillMaxWidth(),
            )
            Spacer(
                modifier = Modifier
                    .height(16.dp),
            )
            Text(
                text = contentDetail.description.toString(),
                fontWeight = FontWeight.Light,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth(),
            )
            Spacer(
                modifier = Modifier
                    .height(16.dp),
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                contentDetail.genre?.let {
                    Text(
                        text = it.joinToString(),
                        fontWeight = FontWeight.Light,
                        color = Color.White,
                        fontSize = 14.sp,
                    )
                }

                Text(
                    text = "•",
                    fontWeight = FontWeight.Light,
                    color = Color.White,
                    fontSize = 14.sp,
                )

                contentDetail.year?.let {
                    Text(
                        text = it,
                        fontWeight = FontWeight.Light,
                        color = Color.White,
                        fontSize = 14.sp,
                    )
                }

                contentDetail.ratings?.let {
                    LazyRow {
                        items(items = it) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        Color.Transparent,
                                    )
                                    .border(
                                        width = 1.dp,
                                        color = Color.White,
                                        shape = RoundedCornerShape(50),
                                    )
                                    .wrapContentSize(),
                            ) {
                                Text(
                                    text = it,
                                    fontWeight = FontWeight.Light,
                                    color = Color.White,
                                    fontSize = 10.sp,
                                    modifier = Modifier
                                        .padding(horizontal = 4.dp),
                                )
                            }
                        }
                    }
                }
            }

            Spacer(
                modifier = Modifier
                    .height(16.dp),
            )

            ElevatedButton(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White,
                ),
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Icon(
                    imageVector = Icons.Rounded.PlayArrow,
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier
                        .size(24.dp),
                )
                Text(
                    text = stringResource(R.string.see),
                    fontWeight = FontWeight.Light,
                    fontSize = 20.sp,
                    color = Color.White,
                )
            }
            Spacer(
                modifier = Modifier
                    .height(16.dp),
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth(),

            ) {
                items(items = contentDetail.chips.orEmpty()) {
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = ButtonColor,
                            contentColor = Color.White,
                        ),
                    ) {
                        Text(
                            text = it,
                            fontWeight = FontWeight.Light,
                            color = Color.White,
                        )
                    }
                }
            }
            Spacer(
                modifier = Modifier
                    .height(16.dp),
            )
            contentDetail.director?.let {
                Spacer(
                    modifier = Modifier
                        .height(16.dp),
                )
                Text(
                    text = stringResource(R.string.director),
                    fontWeight = FontWeight.Light,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(),
                )

                Text(
                    text = it,
                    fontWeight = FontWeight.Light,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(),
                )
            }

            contentDetail.casting?.let {
                Spacer(
                    modifier = Modifier
                        .height(16.dp),
                )
                Text(
                    text = stringResource(R.string.casting),
                    fontWeight = FontWeight.Light,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(),
                )
                it.forEach { cast ->
                    Text(
                        text = cast,
                        fontWeight = FontWeight.Light,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth(),
                    )
                }
            }
            Spacer(
                modifier = Modifier
                    .height(256.dp),
            )
        }
    }
}
