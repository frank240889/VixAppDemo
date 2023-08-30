package dev.franco.vixapp.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.franco.vixapp.ui.data.model.main.ContentStreamModel
import dev.franco.vixapp.ui.theme.VixAppTheme

@Composable
internal fun MainContent(
    modifier: Modifier = Modifier,
    onClickPremium: () -> Unit,
    onClickSearch: () -> Unit,
    onClickProfile: () -> Unit,
    categories: List<String>,
    onClickCategory: () -> Unit,
    mainContent: List<ContentStreamModel>,
    onClickContent: (String, String) -> Unit,
    freemiumContent: Pair<String, List<ContentStreamModel>>,
    onClickFreemiumContent: (String, String) -> Unit,
    premiumContent: Pair<String, List<ContentStreamModel>>,
    onClickPremiumContent: (String, String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(
                8.dp,
            )
            .testTag("main_content")
            .layoutId("main_content"),
    ) {
        TopBar(
            onClickPremium = onClickPremium,
            onClickSearch = onClickSearch,
            onClickProfile = onClickProfile,
        )
        Categories(
            categories = categories,
            onClickCategory = onClickCategory,
        )
        Spacer(
            modifier = Modifier
                .height(16.dp),
        )
        TopContent(
            content = mainContent,
            onClickContent = onClickContent,
        )
        Spacer(
            modifier = Modifier
                .height(16.dp),
        )
        StreamContent(
            title = freemiumContent.first,
            content = freemiumContent.second,
            onClickContent = onClickFreemiumContent,
        )

        Spacer(
            modifier = Modifier
                .height(16.dp),
        )

        StreamContent(
            title = premiumContent.first,
            content = premiumContent.second,
            onClickContent = onClickPremiumContent,
        )
    }
}

@Preview
@Composable
internal fun MainContentPreview() {
    VixAppTheme {
        MainContent(
            onClickPremium = { },
            onClickSearch = { },
            onClickProfile = { },
            categories = emptyList(),
            onClickCategory = {},
            mainContent = emptyList(),
            onClickContent = { _, _ -> },
            freemiumContent = Pair("title", emptyList()),
            onClickFreemiumContent = { _, _ -> },
            premiumContent = Pair("title", emptyList()),
            onClickPremiumContent = { _, _ -> },
        )
    }
}
