package dev.franco.vixapp.ui.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.franco.vixapp.R
import dev.franco.vixapp.ui.theme.ButtonColor

@Composable
internal fun TopBar(
    modifier: Modifier = Modifier,
    onClickPremium: () -> Unit,
    onClickSearch: () -> Unit,
    onClickProfile: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .testTag("top_bar")
            .layoutId("top_bar"),
    ) {
        Row(
            horizontalArrangement = Arrangement
                .spacedBy(8.dp, Alignment.Start),
            modifier = Modifier
                .weight(0.3f),
        ) {
            Image(
                painter = painterResource(R.drawable.vix_logo),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .wrapContentSize(),
            )
        }
        Row(
            horizontalArrangement = Arrangement
                .spacedBy(8.dp, Alignment.End),
            modifier = Modifier
                .weight(0.7f),
        ) {
            OutlinedButton(
                onClick = onClickPremium,
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = ButtonColor,
                    contentColor = Color.White,
                ),
                border = BorderStroke(width = 2.dp, color = Color.Red),
                modifier = Modifier
                    .testTag("premium_button")
                    .layoutId("premium_button"),
            ) {
                Text(
                    text = stringResource(R.string.action_try_out_premium),
                )
            }

            FilledIconButton(
                onClick = onClickSearch,
                shape = RoundedCornerShape(50),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = ButtonColor,
                    contentColor = Color.White,
                ),
                modifier = Modifier
                    .testTag("search_button")
                    .layoutId("search_button"),
            ) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "",
                    tint = Color.White,
                )
            }

            FilledIconButton(
                onClick = onClickProfile,
                shape = RoundedCornerShape(50),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = ButtonColor,
                    contentColor = Color.White,
                ),
                modifier = Modifier
                    .testTag("account_button")
                    .layoutId("account_button"),
            ) {
                Icon(
                    imageVector = Icons.Rounded.Person,
                    contentDescription = "",
                    tint = Color.White,
                )
            }
        }
    }
}
